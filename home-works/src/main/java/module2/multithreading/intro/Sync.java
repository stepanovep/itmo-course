package module2.multithreading.intro;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Egor Stepanov
 * @since 27-11-2017.
 */
public class Sync {

    // Общий участок памяти
    private long cnt;
    // Флаг, сигнализиирующий, что можно выводить результат
    private boolean ready;

    public static void main(String[] args) throws InterruptedException {
        Sync sync = new Sync();
        List<Adder> adders = new ArrayList<>(100);
        Printer printer = sync.new Printer();
        // Создаем потоки
        for (int i = 0; i < 100; i++)
            adders.add(sync.new Adder());

        // Запускаем потоки
        printer.start();
        for (Adder adder : adders)
            adder.start();
    }

    private class Adder extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                // Изменяем общий участок памяти
                synchronized (Sync.this) {
                    if (++cnt % 100_000 == 0) {
                        ready = true;
                        // Разбудим ожидающий поток
                        Sync.this.notify();
                    }
                }
            }
        }
    }

    private class Printer extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (Sync.this) {
                    try {
                        Sync.this.wait();
                        if (ready) {
                            System.out.println("Current result: " + cnt);
                            ready = false;
                            if (cnt == 10_000_000)
                                break;
                        }
                    }
                    catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }
    }
}
