package project.executor;

import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Egor Stepanov
 * @since  14-01-2018.
 */
@Component
public final class NamedExecutors {

    public static NamedThreadPoolExecutor createExecutor(@Nonnull String threadPoolName,
                                                         int corePoolSize) {
        return new NamedThreadPoolExecutor(threadPoolName, corePoolSize, new LinkedBlockingQueue<>(corePoolSize));
    }
}
