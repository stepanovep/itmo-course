package project.command.transfer;

import org.springframework.stereotype.Component;
import project.command.Command;
import project.command.CommandResponse;

/**
 * Команда для возврата средств на счет пользователя
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Component
public class RefundCommand implements Command<RefundRequest, RefundResponse> {

    @Override
    public CommandResponse<RefundResponse> execute(RefundRequest refundRequest) {
        return null;
    }
}
