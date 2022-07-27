package dojo api;

// cd carbon-lang
// bazel run //explorer -- ~/development/cookbook/carbon/a.carbon

fn Main() -> i32 {
    var a: i32 = 42;
    Print("a = {0}", a);

    return 1;
}
