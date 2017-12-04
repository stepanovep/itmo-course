package module2.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Egor Stepanov
 * @since  04-12-2017.
 */
public class PoolExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        List<Future<Integer>> futs = new ArrayList<>(20);

        for (int i = 0; i < 20; i++) {
            int ii = i;
            Future<Integer> fut = pool.submit(() -> {
                Thread.sleep(300);
                System.out.println(Thread.currentThread().getName());
                return ii * ii;
            });

            futs.add(fut);
        }

        for (Future<Integer> fut: futs) {
            System.out.println(fut.get());
        }

        pool.shutdown();
    }
}
