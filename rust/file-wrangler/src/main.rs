use clap::{App, Arg};
use std::{fs, io};
use std::env::temp_dir;
use std::fs::File;
use std::io::prelude::*;
use std::path::{Path, PathBuf};
use serde_derive::Deserialize;
use zip::{read::ZipArchive, write::ZipWriter};
use zip::write::FileOptions;

#[derive(Debug, Deserialize)]
struct Config {
    input_zip: String,
    output_zip: String,
    destination: String,
    files_to_remove: Vec<String>
}

impl Config {
    fn from_args() -> Self {
        let app =  App::new("Zip Manipulator").arg(Arg::with_name("source_zip").required(true))
            .arg(Arg::with_name("working_dir").default_value("."))
            .arg(Arg::with_name("target_zip").required(true))
            .arg(Arg::with_name("destination").required(true));
        let matches = app.get_matches();
        let files = matches.value_of("files_to_remove").unwrap_or("");
        let files_vec: Vec<String> = files.split(',')
            .map(|s| s.trim().to_string())
            .collect();
        Config {
            input_zip: matches.value_of("input_zip").unwrap_or("").to_string(),
            output_zip: matches.value_of("output_zip").unwrap_or(".").to_string(),
            destination: matches.value_of("destination").unwrap_or("").to_string(),
            files_to_remove: files_vec,
        }
    }

    fn from_file(file_path: &str) -> Option<Self> {
        let content = fs::read_to_string(file_path).ok()?;
        toml::from_str(&content).ok()
    }
}

fn move_file_to_folder(file_path: &str, folder_path: &str) -> std::io::Result<()> {
    let input_path = Path::new(file_path);
    let file_name = input_path.file_name().ok_or_else(|| {
        std::io::Error::new(
            std::io::ErrorKind::InvalidInput,
            "Given path does not have a file name.",
        )
    })?;

    let output_path = Path::new(folder_path).join(file_name);

    fs::rename(input_path, output_path)?;
    Ok(())
}

fn remove_files_from_zip(zip_path: &str, files_to_remove: &[&str]) -> Result<(), Box<dyn std::error::Error>> {
    // Open the existing ZIP file
    let reader = File::open(zip_path)?;
    let mut archive = ZipArchive::new(reader)?;

    // Create a temporary file for the new ZIP
    let temp_path = temp_dir().join(PathBuf::from(zip_path).file_name().unwrap());
    let temp_file = File::create(&temp_path)?;

    {
        // Create a new ZIP writer that writes to the temporary file
        let mut zip_writer = ZipWriter::new(temp_file);

        // Iterate over the contents of the original ZIP
        for i in 0..archive.len() {
            let mut file = archive.by_index(i)?;
            let file_name = file.name().to_string();

            // Only copy files that aren't in the list of files to remove
            if !files_to_remove.contains(&file_name.as_str()) {
                let options = FileOptions::default()
                    .compression_method(file.compression())
                    .unix_permissions(file.unix_mode().unwrap_or(0o755));
                zip_writer.start_file(file_name.clone(), options)?;
                let mut contents = vec![];
                file.read_to_end(&mut contents)?;
                zip_writer.write_all(&contents)?;
            }
        }

        zip_writer.finish()?;
    }

    // Overwrite the original ZIP file with the contents of the temporary file
    fs::copy(&temp_path, zip_path)?;
    fs::remove_file(temp_path)?;

    Ok(())
}

fn copy_file(src_path: &str, dest_path: &str) -> io::Result<()> {
    fs::copy(src_path, dest_path)?;
    Ok(())
}

fn main() {
    let config = if Path::new(".config").exists() {
        Config::from_file(".config").expect("Failed to read from .config file")
    } else {
        Config::from_args()
    };

    println!("config found:");
    println!("* {}", &config.input_zip.as_str());
    println!("* {}", &config.output_zip);
    println!("* {}", &config.destination);
    println!("* {}", &config.files_to_remove.join(" "));
    println!();

    match copy_file("input.zip", "output.zip") {
        Ok(_) => println!("File copied successfully!"),
        Err(e) => eprintln!("Error: {}", e),
    }
    match remove_files_from_zip("output.zip", &["foo.txt", "bar.txt"]) {
        Ok(_) => println!("Files removed successfully!"),
        Err(e) => eprintln!("Error: {}", e),
    }
    match move_file_to_folder("output.zip", ".") {
        Ok(_) => println!("File moved successfully!"),
        Err(e) => eprintln!("Error: {}", e),
    }
}
