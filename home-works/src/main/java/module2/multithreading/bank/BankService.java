package module2.multithreading.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Методы банка
 *
 * @author Egor Stepanov
 * @since  11-12-2017.
 */
public class BankService {

    private static final Logger log = LoggerFactory.getLogger(BankService.class);

    public TxResult transferMoney(Account src, Account dest, int amount) {

        if (src.getBalance() < amount) {
            log.info("Not Enough funds to make transaction: balance={}, needed amount={}", src.getBalance(), amount);
            return TxResult.NOT_ENOUGH;
        }

        synchronized (src) {
            src.decBalance(amount);
            dest.incBalance(amount);
            log.info("Transaction from {} to {} is successful", src.getId(), dest.getId());
            return TxResult.SUCCESS;
        }
    }


}
