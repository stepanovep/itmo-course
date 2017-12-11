package module2.multithreading.bank;

/**
 * Генератор аккаунтов
 *
 * @author Egor Stepanov
 * @since  11-12-2017.
 */
public class AccountGenerator {

    public static int id;

    public static Account generate(int balance, int userId) {
        return new Account(id++, balance, userId);
    }
}
