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

// https://www.codewars.com/kata/5583090cbe83f4fd8c000051/train/rust
// https://www.codewars.com/kata/5583090cbe83f4fd8c000051/solutions/rust
// example: 348597 => [7,9,5,8,4,3]
mod kata6 {
    #[allow(unused)]
    pub fn digitize(n: u64) -> Vec<u8> {
        let str: String = n.to_string();
        let mut chars:Vec<char> = str.chars().collect();
        chars.reverse();
        let mut v: Vec<u8> = Vec::new();
        for c in chars {
            let d = c.to_digit(10).unwrap() as u8;
            v.push(d);
        }
        return v;
    }
}

mod kata7 {
    #[allow(unused)]
    pub fn code() -> () {
        let data = vec![0, 1, 1, 1];
        let s: String = data.iter().map(|d| d.to_string()).rev().collect();
        println!("# {}", s)
    }
}

mod kata8 {
    #[allow(unused)]
    pub fn code() {
        println!("# nested functions ready.");

        fn fetch_data() -> String {
            return String::from("01001010");
        }

        println!("# fetching data");

        let data: String = fetch_data();
        println!("# data fetched: {}", data)
    }
}

mod kata9 {
    #[allow(unused)]
    pub fn code() {
        println!("# match: like switch in java");

        for x in 0..7 {
            print!("{}: ", x);

            match x {
                0 | 1 => println!("binary"),
                2 | 4 => println!("even number"),
                _ => println!("undefined number")
            }
        }
    }
}

mod kata10 {
    #[allow(unused)]
    pub fn code() {
        let a: i8 = 127;

        let v = a.to_string().chars()
        .map(|c| c.to_digit(10).unwrap() as u8)
        // .rev()
        .collect::<Vec<u8>>();

        for i in 0..v.len() {
            println!("{:?}", v[i]);
        }
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

    // kata5::count_sheep(&[true, true, true, false, true, false, true, false]);

    // let n: u64 = 700;
    // kata6::digitize(n);

    // kata7::code();
    // kata8::code();
    // kata9::code();
    kata10::code();
}
