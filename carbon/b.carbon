package dojo api;

// cd carbon-lang
// bazel run //explorer -- ~/development/cookbook/carbon/b.carbon

// expressions
// https://github.com/carbon-language/carbon-lang/blob/trunk/docs/design/README.md#expressions

fn TubleExample() -> (i32, i32) {
    return (8, 16);
}

fn Main() -> i32 {
    var s: String = "Carbon experimental - 0.1";

    var b: Bool = true;
    if (b) {
        Print(s);
    }

    // # control flow
    // var c: i32 = if b then 40 + 2 else 42 / 2 - 0;
    // syntax error, unexpected SLASH, expecting SEMICOLON
    var c: i32 = if not b then 40 + 2 else 21 * 2 - 42 * 2;
    Print("if-then-else works: {0}", c);

    // constant
    let pi: i32 = 314;
    Print("pi: {0}", pi);

    // type inference
    let d: auto = 00010;
    Print("d: {0}", d);

    return 1;
}
