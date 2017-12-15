package module2.multithreading.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Egor Stepanov
 * @since  11-12-2017.
 */
public class Bank {

    private final int POOL_SIZE = 10;
    private final ExecutorService pool;
    private final BankService bankService;

    private static final Logger log = LoggerFactory.getLogger(Bank.class);

    public Bank() {
        this.pool = Executors.newFixedThreadPool(POOL_SIZE);
        this.bankService = new BankService();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Bank().start();
    }

    private void start() {
        Account account1 = new Account(1, 1000, 1);
        Account account2 = new Account(2, 0, 2);

        bankService.transferMoney(account1, account2, 500);
    }

}
