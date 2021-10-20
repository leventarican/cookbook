public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Main");
        Main main = new Main();
        main.run();
    }

    private void run() {
        try {
            getClass().getClassLoader().loadClass("Utility").newInstance();
        } catch(ClassNotFoundException error) {
            System.out.println("Main: missing classpath?");
        } catch(InstantiationException error) {
            System.out.println("Main: class found but cant instantiate");
        } catch(IllegalAccessException error) {
            System.out.println("Main: access violation");
        }
    }
}
