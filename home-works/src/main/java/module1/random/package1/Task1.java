package module1.random.package1;

import java.util.Random;

/**
 * Вывести на экран число четное или нечетное
 *
 * @author Egor Stepanov
 * @since 13/10/2017.
 */
public class Task1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int n = rnd.nextInt() % 1000;
        System.out.println("Сгенерировано число n = " + n);
        System.out.println(isOdd(n) ? "Четный" : "Нечетный");
    }

    private static boolean isOdd(int n) {
        return (n & 1) == 0;
    }
}
