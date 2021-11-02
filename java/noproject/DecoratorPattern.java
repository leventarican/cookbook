/*
decorator uses delegation.
*/
public class DecoratorPattern {
    public static void main(String[] args) {
        System.out.println("# decorator pattern, GoF, structural patterns, composition");
        var computer = new Computer();
        computer.operation();
        var mobile = new MobileComputer(computer);
        mobile.gpsOperation();
    }
}

final class Computer {
    public void operation() {
        System.out.println("# do some operations.");
    }
}

// hmmm how to extend Computer? --> decorate it.
// class MobileComputer extends Computer {}

class MobileComputer {
    private Computer computer;
    MobileComputer(Computer c) {
        computer = c;
    }
    public void gpsOperation() {
        System.out.println("# GPS on.");
        computer.operation();
    }
}
