package project.command.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.command.Command;
import project.command.CommandResponse;
import project.command.account.model.DeleteAccountRequest;
import project.repository.AccountRepository;

/**
 * Команда для удаления счета из БД
 *
 * @author Egor Stepanov
 * @since 13-01-2018.
 */
@Component
public class DeleteAccountCommand implements Command<DeleteAccountRequest, Void> {

    private static final Logger log = LoggerFactory.getLogger(DeleteAccountCommand.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CommandResponse<Void> execute(DeleteAccountRequest request) {

        log.info("Deleting account: request={}", request);

        if (request.getId() != null) {
            accountRepository.delete(request.getId());
        } else if (request.getName() != null) {
            accountRepository.delete(accountRepository.findAccountByName(request.getName()));
        } else {
            accountRepository.delete(accountRepository.findAccountByContact(request.getContact()));
        }

        log.info("Account successfully deleted");
        return CommandResponse.success();
    }
}
