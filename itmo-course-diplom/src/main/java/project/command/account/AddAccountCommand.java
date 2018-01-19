package project.command.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.command.Command;
import project.command.CommandResponse;
import project.command.account.model.AddAccountRequest;
import project.command.account.model.AddAccountResponse;
import project.entity.Account;
import project.repository.AccountRepository;

import java.time.LocalDateTime;

/**
 * Добавить аккаунт в базу
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Component
public class AddAccountCommand implements Command<AddAccountRequest, AddAccountResponse> {

    private static final Logger log = LoggerFactory.getLogger(AddAccountCommand.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CommandResponse<AddAccountResponse> execute(AddAccountRequest request) {
        log.info("AddAccountCommand(): request={}", request);

        if (accountRepository.isExists(request.getName(), request.getContact())) {
            log.info("Account with the same name/contact already exists in system. Account={}", request);
            return CommandResponse.error("Account with the same name and(or) contact already exists in system");
        }

        Account account = new Account(request.getName(), request.getContact());
        account.setBalance(request.getInitialBalance() != null ? request.getInitialBalance() : 0.0);
        account.setRegistrationTime(LocalDateTime.now());
        accountRepository.save(account);

        log.info("Successfully added a new account: {}", account);
        return CommandResponse.success(AddAccountResponse.builder()
                .id(account.getId())
                .name(account.getName())
                .contact(account.getContact())
                .balance(account.getBalance())
                .build());
    }
}
