package homework2.package3;

import java.util.Scanner;

/**
 * @author Egor Stepanov
 * @since 14/10/2017.
 */
public class Tasks_5_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(n + "! = " + factorial(n));
    }

    private static long factorial(int n) {
        long f = 1;
        for (long i = 1; i <= n; i++) {
            f *= i;
        }

        return f;
    }


}
