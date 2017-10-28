package module1.random.package2;

import java.util.Random;

import static java.lang.Math.max;

/**
 * @author Egor Stepanov
 * @since 13/10/2017.
 */
public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();

        int n = rnd.nextInt(900) + 100;
        System.out.println("Generated number n = " + n);

        int d1 = n / 100;
        int d2 = (n / 10) % 10;
        int d3 = n % 10;

        System.out.println("max digit = " + max(d1, max(d2, d3)));
    }
}
