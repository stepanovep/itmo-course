package homework2.package2;

import java.util.Random;

/**
 * @author Egor Stepanov
 * @since 13/10/2017.
 */
public class Task1 {

    private static final int L = 25;
    private static final int R = 100;


    public static void main(String[] args) {
        Random rnd = new Random();
        int n = rnd.nextInt(151) + 5;

        System.out.println("Generated number = " + n);
        System.out.println("Is the number inside ["+ L + ", " + R + "] ?");
        System.out.println((L <= n && n <= R) ? "Yes" : "No");
    }
}
