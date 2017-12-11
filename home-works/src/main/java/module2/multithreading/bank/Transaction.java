package module2.multithreading.bank;

/**
 * @author Egor Stepanov
 * @since 11-12-2017.
 */
public class Transaction {

    private final Account src;
    private final Account dest;
    private final int amount;

    public Transaction(Account src, Account dest, int amount) {
        this.src = src;
        this.dest = dest;
        this.amount = amount;
    }

    public Account getSrc() {
        return src;
    }

    public Account getDest() {
        return dest;
    }

    public int getAmount() {
        return amount;
    }
}
