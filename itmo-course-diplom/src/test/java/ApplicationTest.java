import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import project.command.transfer.TransferCommand;
import project.command.transfer.TransferRequest;
import project.repository.AccountRepository;

/**
 * @author Egor Stepanov
 * @since 12-01-2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

    @Mock
    private AccountRepository accountRepository;

    private TransferCommand transferCommand;

    @Test
    public void test() {

        TransferRequest request = TransferRequest.builder()
                .accountIdFrom(123L)
                .accountIdTo(200L)
                .amount(314.15)
                .build();

        transferCommand.execute(request);
    }
}
