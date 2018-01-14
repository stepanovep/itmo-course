package project.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Egor Stepanov
 * @since  14-01-2018.
 */
public class NamedThreadFactory implements ThreadFactory {

    private static final AtomicInteger poolNumber = new AtomicInteger(0);
    private final AtomicInteger threadNumber = new AtomicInteger(0);
    private final ThreadFactory threadFactory = Executors.defaultThreadFactory();
    private final String namePrefix;

    public NamedThreadFactory(String threadFactoryName) {
        this.namePrefix = String.format("%s-%d-", threadFactoryName, poolNumber.getAndIncrement());
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = threadFactory.newThread(r);
        thread.setName(namePrefix + threadNumber.getAndIncrement());
        return thread;
    }
}
