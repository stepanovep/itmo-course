package module2.multithreading.intro;

/**
 * @author Egor Stepanov
 * @since 27-11-2017.
 */
public class ThreadExample {

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception");
            }
            System.out.println("thread1 run");
        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("thread2 run");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        thread1.start();

        Thread thread2 = new Thread(new Thread2());
        thread2.start();
    }
}
