use std::fs::File;
use std::io::prelude::*;
use std::path::Path;
use std::time::Instant;

fn create_file(filename: String, content: &str) {
    let path = Path::new(&filename);
    let display = path.display();

    println!("file path: {}", display);

    let mut file = match File::create(&path) {
        Err(why) => panic!("couldn't create {}: {}", display, why),
        Ok(file) => file
    };

    match file.write_all(content.as_bytes()) {
        Err(why) => panic!("couldn't write to {}: {}", display, why),
        Ok(_) => println!("successfully wrote to {}", display),
    }
}

fn create_files(s: &str, content: &str) {
    // https://doc.rust-lang.org/nightly/std/primitive.str.html#method.parse
    // https://mkaz.blog/working-with-rust/numbers/
    let number: i16 = s.parse().unwrap();
    let filename = "generated";
    println!("number: {}; filename: {}", number, filename);
    for _n in 0..number {
        // https://mkaz.blog/working-with-rust/strings/
        let postfix = _n.to_string();
        // String to str slice: borrowing with &postfix
        let filename_with_postfix = [filename, &postfix].join(".");
        println!("filename_with_postfix: {}", filename_with_postfix);
        create_file(filename_with_postfix, content);
    }
}

fn random_line() -> String {
    use std::char::from_u32;

    let mut line = String::new();
    // https://doc.rust-lang.org/nightly/std/char/fn.from_u32.html
    for _i in 48..123 as u32 {
        // 0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz
        let c = from_u32(_i).unwrap();
        // print!("{}->{}; ", _i, c);
        line.push(c);
    }
    line
}

fn generate() -> () {
    println!("generate ...");
    let line: String = random_line();
    println!("{}", line);
    
    let mut g = String::new();
    for _ in 0..10 {
        g += &line;
    }
    create_files("1000", &g);
}

fn main() {
    let now = Instant::now();

    generate();

    // https://doc.rust-lang.org/nightly/std/time/struct.Duration.html
    let elapsed_ms = now.elapsed().as_millis();
    println!("time elapsed [ms]: {}", elapsed_ms);
}
