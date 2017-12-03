package module2.multithreading.intro;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Egor Stepanov
 * @since 27-11-2017.
 */
public class Deadlock {

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();

        AtomicBoolean locked1 = new AtomicBoolean();
        AtomicBoolean locked2 = new AtomicBoolean();

        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                locked1.set(true);
                System.out.println("T1 locked o1");
                if (locked2.get()) {
                    synchronized (o2) {
                        System.out.println("T1 locked o2");
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (o2) {
                locked2.set(true);
                System.out.println("T2 locked o2");
                if (locked1.get()) {
                    synchronized (o1) {
                        System.out.println("T2 locked o1");
                    }
                }
            }
        });

        t1.start();
        t2.start();

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
