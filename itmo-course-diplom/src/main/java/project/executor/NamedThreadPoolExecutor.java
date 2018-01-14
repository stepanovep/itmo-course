package project.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Egor Stepanov
 * @since  14-01-2018.
 */
public class NamedThreadPoolExecutor extends ThreadPoolExecutor implements AutoCloseable {

    private static final Logger log = LoggerFactory.getLogger(NamedThreadPoolExecutor.class);

    @Nonnull
    private final String threadPoolName;

    NamedThreadPoolExecutor(@Nonnull String threadPoolName,
                            int corePoolSize,
                            @Nonnull BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, corePoolSize, 0L, TimeUnit.SECONDS,
                Objects.requireNonNull(workQueue, "workQueue"),
                new NamedThreadFactory(Objects.requireNonNull(threadPoolName, "threadPoolName")));
        this.threadPoolName = threadPoolName;
    }

    @Nonnull
    public String getThreadPoolName() {
        return threadPoolName;
    }

    @Override
    public void close() throws Exception {
        log.info("closing pool: name={}", threadPoolName);
        shutdown();
    }
}
