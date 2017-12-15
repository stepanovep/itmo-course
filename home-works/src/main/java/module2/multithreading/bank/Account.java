package module2.multithreading.bank;

/**
 * Аккаунт
 *
 * @author Egor Stepanov
 * @since  11-12-2017.
 */
public class Account {

    private final int id;
    private int balance;
    private final int userId;

    public Account(int id, int balance, int userId) {
        this.id = id;
        this.balance = balance;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public int getUserId() {
        return userId;
    }

    public void withDraw(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }



    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", userId=" + userId +
                '}';
    }
}
