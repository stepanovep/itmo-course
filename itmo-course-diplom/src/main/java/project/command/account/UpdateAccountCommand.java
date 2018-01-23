package project.command.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import project.command.Command;
import project.command.CommandResponse;
import project.command.account.model.UpdateAccountRequest;
import project.entity.Account;
import project.repository.AccountRepository;

/**
 * Команда для изменения данных счета
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Component
public class UpdateAccountCommand implements Command<UpdateAccountRequest, Void> {

    private static final Logger log = LoggerFactory.getLogger(UpdateAccountCommand.class);

    private final AccountRepository accountRepository;

    public UpdateAccountCommand(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public CommandResponse<Void> execute(UpdateAccountRequest request) {

        Account account = accountRepository.findOne(request.getId());
        if (account == null) {
            log.info("Account not found: id={}", request.getId());
            return CommandResponse.error("Account not found");
        }

        if (request.getNewName() != null) {
            account.setName(request.getNewName());
        }

        if (request.getNewContact() != null) {
            account.setContact(request.getNewContact());
        }

        log.info("Account successfully updated: {}", account);
        accountRepository.save(account);
        return CommandResponse.success();
    }
}
