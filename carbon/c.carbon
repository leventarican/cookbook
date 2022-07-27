package dojo api;

// cd carbon-lang
// bazel run //explorer -- ~/development/cookbook/carbon/c.carbon

class Machine {
    var id: i32;
    var active: Bool;
    var payload: String;
}

fn Main() -> i32 {
    Print("oop");

    var m: Machine;
    // m.id = 0;
    // field access not allowed for value
    m = {.id = 3, .active = true, .payload = "header;data"};

    Print("machine id: {0}", m.id);

    return 1;
}
