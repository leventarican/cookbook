import java.util.*;
import java.util.stream.*;

public class Main {
    class A extends Machine implements D {
        void code() {
            for (int i=1; i<3; i++) {
                var data = A.class.getName() + " produced data:" + i;
                System.out.println(data);
                push(data);
            }
        }
    }
    static class B extends Machine implements Main.D {
        void code() {
            var data = popData();
            System.out.println(B.class.getName() + " consumed data: " + data);
        }
    }
    // interface is always static
    interface C {}
    static interface D {
        static Stack<String> container = new Stack<>();
        default void push(String data) {
            container.push(data);
        }
        default String popData() {
            return container.pop();
        }
    }
    static {
        System.out.println("# initializing");
    }
    private String data;
    public int version;
    protected long id;
    public static void main(String[] args) {
        System.out.println("# main: " + Main.class.getName());

        var a = new Main().new A();
        a.code();

        var b = new Main.B();
        var c = new B();
        b.code();
        c.code();

        IntStream.range(1, 5).forEach(System.out::println);
    }
}

abstract class Machine {
    static {
        System.out.println("# init: " + Machine.class.getName());
    }
    abstract void code();
}
