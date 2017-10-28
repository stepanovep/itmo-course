package module1.cycles;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Egor Stepanov
 * @since 14/10/2017.
 */
public class Task_5_9 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(n + "! = " + factorial(n));
        System.out.println();

        n = in.nextInt();
        System.out.println("Делители числа " + n + ':');
        printDivisors(n);
        System.out.println();

        n = in.nextInt();
        System.out.println(String.format("Число %d - %s", n, isPrime(n) ? "простое" : "составное"));

        System.out.println();
        n = in.nextInt();
        System.out.println("Первые " + n + " чисел Фибоначчи:");
        printFibonacci(n);
    }

    private static long factorial(int n) {
        long f = 1;
        for (long i = 1; i <= n; i++) {
            f *= i;
        }

        return f;
    }

    private static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i);
                System.out.print(' ');
            }
        }
        System.out.println();
    }

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i*i <= n; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void printFibonacci(int n) {
        if (n > 2) {
            int[] f = new int[n];
            f[0] = 1;
            f[1] = 1;
            for (int i = 2; i < n; i++) {
                f[i] = f[i-1] + f[i-2];
            }

            System.out.println(Arrays.toString(f));
        } else {
            System.out.println("Try with n > 1");
        }
    }

    /**
     * Вычислить сумму цифр числа
     */
    private static int getDigitsSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

}
