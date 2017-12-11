package module2.multithreading.bank;

/**
 * @author Egor Stepanov
 * @since  11-12-2017.
 */
public class UserGenerator {
    public static int id;

    public static User generate(String name) {
        return new User(id++, name);
    }
}
