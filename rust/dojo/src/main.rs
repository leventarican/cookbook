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

// https://www.codewars.com/kata/576bb71bbbcf0951d5000044/solutions/rust
mod kata4 {
    #[allow(unused)]
    pub fn count_positives_sum_negatives(input: Vec<i32>) -> Vec<i32> {
        if input.len() < 1 {
            return vec![];
        }

        let mut p = 0;
        let mut n = 0;

        for i in 0..input.len() {
            if input[i] > 0 {
                println!("p: {}", input[i]);
                p += 1
            } else {
                println!("n: {}", input[i]);
                n += input[i]
            }
        }

        println!("#");

        let out = vec![p, n];
        for i in 0..out.len() {
            println!("{}", out[i]);
        }
        return out;
    }
}

// https://www.codewars.com/kata/54edbc7200b811e956000556/train/rust
mod kata5 {
    #[allow(unused)]
    pub fn count_sheep(sheep: &[bool]) -> u8 {
        let a = sheep.iter().filter(|x| **x == true).count() as u8;
        println!("{}", a);
        return a
    }
}

#[allow(unused)]
static RUST: &str = "RUST";

fn main() {
    // kata0::code();
    // kata1::code();
    // kata2::switch();
    // kata3::to_base64(&RUST)

    // let k4 = vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15];
    // kata4::count_positives_sum_negatives(k4);

    kata5::count_sheep(&[true, true, true, false, true, false, true, false]);
}
