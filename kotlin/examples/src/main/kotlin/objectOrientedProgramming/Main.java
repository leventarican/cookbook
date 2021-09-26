package objectOrientedProgramming;

public class Main {
    public static void main(String[] args) {
        // object class = singleton
        // var a = new Singleton();

        var a = Singleton.INSTANCE;
        a.code0();
    }
}
