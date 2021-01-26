
fn multiply(a:i8, b:i8) -> i8 {
    a * b
}

fn main() {
    let mut a: i8 = 1_0;
    a = a - 1;
    println!("{}", a);

    let fixed_size: [i8; 3] = [1, 20, 127];
    println!("fixed_size: {}", fixed_size[fixed_size.len()-1]);

    let b = fixed_size[0];
    let m = multiply(a, b);
    println!("multiply: {}", m);

    let e = {
        let a = 2 * 4;
        let b = a % 2;
        a + b + 10
    };
    println!("expression e: {}", e)
}
