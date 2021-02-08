mod kata1 {
    use std::fs::File;
    use std::io::prelude::*;
    
    // #[allow(dead_code)]
    pub fn code() -> std::io::Result<()> {
        let mut file = File::create("ignore.txt")?;
        file.write_all(b"RUST")?;
        Ok(())
    }
}

mod kata0 {
    // #[allow(dead_code)]
    pub fn code() -> () {
        println!("kata0::code()")
    }
}

fn main() {
    kata0::code();
    kata1::code();
}
