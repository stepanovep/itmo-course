package project.engine.executor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import project.command.Command;
import project.command.CommandResponse;

/**
 * Исполнитель команд
 *
 * @author Egor Stepanov
 * @since  15-01-2018.
 */
public class ProjectCommandExecutor {

    private final DeferredResultExecutor deferredResultExecutor;

    public ProjectCommandExecutor(DeferredResultExecutor deferredResultExecutor) {
        this.deferredResultExecutor = deferredResultExecutor;
    }

    public <RequestT, ResponseT>DeferredResult<ResponseEntity<CommandResponse<ResponseT>>> executeCommand(
            Command<RequestT, ResponseT> command, RequestT request) {
        return deferredResultExecutor.async(() -> {
            CommandResponse<ResponseT> response = command.execute(request);
            HttpStatus status = response.getStatus() != CommandResponse.Status.ERROR
                    ? HttpStatus.OK
                    : HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(response, status);
        });
    }
}
