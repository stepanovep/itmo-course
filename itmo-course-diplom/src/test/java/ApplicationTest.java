import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import project.entity.Account;
import project.repository.AccountRepository;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * @author Egor Stepanov
 * @since 12-01-2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void test() {
        when(accountRepository.findOne(anyLong())).thenReturn(new Account("blah", "test@test.ru"));
        System.out.println(accountRepository.findOne(1L).getName());
    }
}
