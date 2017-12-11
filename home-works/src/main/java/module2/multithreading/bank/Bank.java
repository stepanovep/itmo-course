package module2.multithreading.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static module1.utils.RandomUtils.generateInt;

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

    private void start() throws ExecutionException, InterruptedException {
        List<Account> accounts = new ArrayList<>();
        List<Future<TxResult>> futs = new ArrayList<>();
        int userId = 0;

        for (int i = 0; i < POOL_SIZE; i++) {
            accounts.add(AccountGenerator.generate(generateInt(0, 100), userId++));
        }

        for (int i = 0; i < POOL_SIZE; i++) {
            Future<TxResult> fut = pool.submit(new Transfer(new Transaction(
                    accounts.get(generateInt(0, POOL_SIZE-1)),
                    accounts.get(generateInt(0, POOL_SIZE-1)),
                    generateInt(0, 50))));
            futs.add(fut);
        }

        for (Future<TxResult> fut : futs) {
            fut.get();
        }

        pool.shutdown();
    }

    public TxResult transferMoney(Account src, Account dest, int amount) {
        Future<TxResult> future = pool.submit(new Transfer(new Transaction(src, dest, amount)));
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException ignored) {
            throw new RuntimeException();
        }
    }

    private class Transfer implements Callable<TxResult> {

        private final Transaction transaction;

        private Transfer(Transaction transaction) {
            this.transaction = transaction;
        }

        @Override
        public TxResult call() {
            log.info("Transaction in progress: src={}, dest={}, amount={}", transaction.getSrc().getId(), transaction.getDest().getId(), transaction.getAmount());
            return bankService.transferMoney(transaction.getSrc(), transaction.getDest(), transaction.getAmount());
        }
    }
}
