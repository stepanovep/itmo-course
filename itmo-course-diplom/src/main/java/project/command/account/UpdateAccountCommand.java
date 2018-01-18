package project.command.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.command.Command;
import project.command.CommandResponse;
import project.entity.Account;
import project.repository.AccountRepository;

/**
 * Команда для изменения данных счета
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Component
public class UpdateAccountCommand implements Command<Account, Void> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CommandResponse<Void> execute(Account account) {
        return null;
    }
}
