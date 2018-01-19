import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.application.Application;
import project.command.CommandResponse;
import project.command.transfer.TransferCommand;
import project.command.transfer.TransferRequest;
import project.command.transfer.TransferResponse;
import project.engine.fsm.TransferProcessExecutor;
import project.entity.Account;
import project.repository.AccountRepository;
import project.repository.TransactionRepository;

/**
 * @author Egor Stepanov
 * @since 12-01-2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private static final String TEST_USER1 = "testUser1";
    private static final String TEST_USER2 = "testUser2";

    @Test
    public void test() {
        Account accountFrom = accountRepository.findAccountByName(TEST_USER1);
        if (accountFrom == null) {
            accountFrom = accountRepository.save(new Account(TEST_USER1, "7991123123", 100.0));
        }

        Account accountTo = accountRepository.findAccountByName(TEST_USER2);
        if (accountTo == null) {
            accountTo = accountRepository.save(new Account(TEST_USER2, "testUser2@yandex.ru", 200.0));
        }
        //accountRepository.setBalance(accountFrom.getId(), 100.0);
        //accountRepository.setBalance(accountTo.getId(), 200.0);

        TransferProcessExecutor transferProcessExecutor = new TransferProcessExecutor(
                accountRepository, transactionRepository);

        TransferCommand transferCommand = new TransferCommand(transferProcessExecutor);

        TransferRequest request = TransferRequest.builder()
                .accountIdFrom(accountFrom.getId())
                .accountIdTo(accountTo.getId())
                .amount(50.0)
                .build();

        CommandResponse<TransferResponse> commandResponse = transferCommand.execute(request);

        accountFrom = accountRepository.findAccountByName(TEST_USER1);
        accountTo = accountRepository.findAccountByName(TEST_USER2);

        Assert.assertEquals(commandResponse.getStatus(), CommandResponse.Status.SUCCESS);
        Assert.assertTrue(accountFrom.getBalance().compareTo(100.0 - 50.0) == 0);
        Assert.assertTrue(accountTo.getBalance().compareTo(200.0 + 50.0) == 0);
    }
}
