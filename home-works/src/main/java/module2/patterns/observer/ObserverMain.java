package module2.patterns.observer;

public class ObserverMain {

    public static void main(String[] args) throws InterruptedException {
        Sensor sensor = new Sensor(0, 50);
        sensor.addListener(new Green(100), new Yellow(300), new Red(600));

        for (int i = 0; i < 15; i++) {
            sensor.incrementTemp();
            Thread.sleep(500);
        }
    }
}
