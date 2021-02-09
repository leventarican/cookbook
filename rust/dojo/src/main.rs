mod kata0 {
    #[allow(dead_code)]
    pub fn code() -> () {
        println!("kata0::code()")
    }
}

mod kata1 {
    use std::fs::File;
    use std::io::prelude::*;
    
    #[allow(dead_code)]
    pub fn code() -> std::io::Result<()> {
        let mut file = File::create("ignore.txt")?;
        file.write_all(b"RUST")?;
        Ok(())
    }
}

mod kata2 {
    #[allow(unused)]
    pub fn switch() {
        println!("switch in rust");
        let num = 20;
        match num {
            0 => println!("number 0: {}", num),
            2 | 20 => println!("number 2 or 20: {}", num),
            _ => println!("number >20: {}", num)
        }
    }
}

mod kata3 {
    #[allow(unused)]
    pub fn to_base64(s: &str) {
        println!("{}", base64::encode(s));
    }
}

static RUST: &str = "RUST";

fn main() {
    // kata0::code();
    // kata1::code();
    // kata2::switch();
    kata3::to_base64(&RUST)
}
