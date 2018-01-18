package project.engine.executor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.function.Supplier;

/**
 * Асинхронный исполнитель
 *
 * @author Egor Stepanov
 * @since 15-01-2018.
 */
public class DeferredResultExecutor {

    private final NamedThreadPoolExecutor namedThreadPoolExecutor;

    public DeferredResultExecutor(NamedThreadPoolExecutor namedThreadPoolExecutor) {
        this.namedThreadPoolExecutor = namedThreadPoolExecutor;
    }

    public <RespT> DeferredResult<ResponseEntity<RespT>> async(Supplier<ResponseEntity<RespT>> callable) {
        DeferredResult<ResponseEntity<RespT>> deferredResult = new DeferredResult<>();
        namedThreadPoolExecutor.execute(() -> {
            try {
                ResponseEntity<RespT> response = callable.get();
                deferredResult.setResult(response);
            } catch (Throwable throwable) {
                deferredResult.setErrorResult(throwable);
            }
        });

        return deferredResult;
    }
}
