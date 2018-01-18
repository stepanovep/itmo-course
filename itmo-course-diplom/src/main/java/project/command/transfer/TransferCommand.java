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

/**
 * Команда для перевода средсв между счетами
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Component
public class TransferCommand implements Command<TransferRequest, TransferResponse> {

    private static final Logger log = LoggerFactory.getLogger(TransferCommand.class);

    @Autowired
    TransferProcessExecutor transferProcessExecutor;

    @Override
    public CommandResponse<TransferResponse> execute(TransferRequest transferRequest) {
        log.info("TransferCommand(): request={}", transferRequest);

        TransferContext context = TransferContext.createContext();
        Process process = new Process(context, 123L);
        transferProcessExecutor.execute(process);

        TransferResponse response = TransferResponse.builder()
                .comment("comment test")
                .build();

        return CommandResponse.success(response);
    }
}
