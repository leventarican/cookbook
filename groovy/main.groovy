print "gro"
println "ovy"

def groovy = "groovy"

def lang = new ProgrammingLang()
lang.name = "java"
lang.print()

def list = []
list.add(0)
list.add(1)

def maps = ["java": "System.out.println"]
maps.groovy = "println"
println(maps)

def boo = true
if (boo) {
    println "boo is true"
}

boo = false
if (boo) println "boo is true"
else println "boo is false"

// elvis operator: http://groovy-lang.org/operators.html#_elvis_operator
def foo = boo ?: "elvis"
println "foo can be boolean or String: " + foo

def a_method() {
    println "method called"
}
a_method()

// { [closureParameters -> ] statements }
// closure: a block of code with parameter left to ->
def a_closure_0 = { parameter_x, parameter_y -> 
    parameter_x + parameter_y
}
println(a_closure_0(3,4))

// if only one argument then it can be referenced with _it_
def a_closure_1 = {it * 2}
println a_closure_1(3)

// http://groovy-lang.org/semantics.html#_for_in_loop
for (i in 0..9) {
    print i
}
println '\nTHE END.'
