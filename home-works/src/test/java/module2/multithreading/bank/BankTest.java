package module2.multithreading.bank;

import org.junit.Test;
import org.testng.Assert;

/**
 * @author Egor Stepanov
 * @since  11-12-2017.
 */
public class BankTest {

    @Test
    public void bankTest() {
        Bank bank = new Bank();

        Account account1 = AccountGenerator.generate(50, 1);
        Account account2 = AccountGenerator.generate(20, 2);

        TxResult result = bank.transferMoney(account1, account2, 40);

        Assert.assertEquals(result, TxResult.SUCCESS);
        Assert.assertEquals(account1.getBalance(), 10);
        Assert.assertEquals(account2.getBalance(), 60);
    }
}
