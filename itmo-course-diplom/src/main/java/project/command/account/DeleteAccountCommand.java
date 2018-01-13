package project.command.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.command.Command;
import project.command.CommandResult;
import project.repository.AccountRepository;

/**
 * @author Egor Stepanov
 * @since 13-01-2018.
 */
@Component
public class DeleteAccountCommand implements Command<Long, Void> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CommandResult<Void> execute(Long aLong) {
        return null;
    }
}
