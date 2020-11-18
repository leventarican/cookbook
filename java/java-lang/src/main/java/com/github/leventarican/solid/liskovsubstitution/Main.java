package com.github.leventarican.solid.liskovsubstitution;

/**
 * every subclass or derived class should be substitutable for their parent or
 * base class;
 *
 * @author levent
 */
public class Main {

    public static void main(String[] args) {
        var comp = new Computer();
        comp.compile(new JavaCode());
        comp.compile(new PythonCode());
        
        var java = new JavaDeveloper();
        java.code(new JVMCode("kotlin"));
    }
}

class JavaCode implements Code {

    @Override
    public String language() {
        return "java";
    }

}

class PythonCode implements Code {

    @Override
    public String language() {
        return "python";
    }

}
