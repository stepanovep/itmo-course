package project.command.transfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.command.Command;
import project.command.CommandResponse;
import project.engine.fsm.Process;
import project.engine.fsm.TransferContext;
import project.engine.fsm.TransferProcessExecutor;
import project.engine.fsm.TransferStage;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Команда для перевода средств между счетами
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Component
public class TransferCommand implements Command<TransferRequest, TransferResponse> {

    private static final Logger log = LoggerFactory.getLogger(TransferCommand.class);

    @Autowired
    private TransferProcessExecutor transferProcessExecutor;

    private AtomicLong processCounter = new AtomicLong(0L);

    @Override
    public CommandResponse<TransferResponse> execute(TransferRequest transferRequest) {
        log.info("TransferCommand(): request={}", transferRequest);

        TransferContext context = TransferContext.createContext();
        context.setRequest(transferRequest);
        Process process = new Process(context, processCounter.getAndIncrement());
        transferProcessExecutor.execute(process);

        if (context.getStage() == TransferStage.FAILED) {
            return CommandResponse.error(context.getErrorMessage());
        }

        return CommandResponse.success(TransferResponse.builder()
                .comment("success transfer")
                .build());
    }
}
