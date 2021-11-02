public class ProxyPattern {
    static class Driver {}
    static class Car {
        static void drive() {
            System.out.println("# car is driving.");
        }
        void stop() {
            System.out.println("# car is stopping.");
        }
    }
    static class TheProxy {
        static Driver driver;
        static Car car = new Car();
        TheProxy(Driver driver) {
            this.driver = driver;
        }
        static void drive() {
            if (driver != null) {
                car.drive();
            } else {
                car.stop();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("# proxy pattern.");

        ProxyPattern.Car.drive();
        new ProxyPattern.Car().stop();

        TheProxy.drive();
        new TheProxy(new Driver()).drive();
        // what do you expect here? --> drive because static object has already a driver.
        TheProxy.drive();
    }
}
