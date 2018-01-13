package project.command.transfer;

import org.springframework.stereotype.Component;
import project.command.Command;
import project.command.CommandResult;

/**
 * @author Egor Stepanov
 * @since 13-01-2018.
 */
@Component
public class TransferCommand implements Command<TransferRequest, TransferResponse> {

    @Override
    public CommandResult<TransferResponse> execute(TransferRequest transferRequest) {
        return null;
    }
}
