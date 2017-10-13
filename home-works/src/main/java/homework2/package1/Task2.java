package homework2.package1;

import java.util.Random;

/**
 * Из двух точек на прямой определить ближайший к заданной
 *
 * @author Egor Stepanov
 * @since 13/10/2017.
 */
public class Task2 {

    private static final double TEN = 10.0;

    public static void main(String[] args) {
        Random rnd = new Random();
        double n = rnd.nextDouble() * 20;
        double m = rnd.nextDouble() * 20;

        if (Math.abs(n - TEN) < Math.abs(m - TEN)) {
            System.out.println(String.format("Number n=%.2f is closer to %s then m=%.2f", n, TEN, m));
        } else if (Math.abs(n - TEN) > Math.abs(m - TEN)) {
            System.out.println(String.format("Number m=%s is closer to %s then n=%s", m, TEN, n));
        } else {
            System.out.println("The distances are equal!");
        }
    }
}
