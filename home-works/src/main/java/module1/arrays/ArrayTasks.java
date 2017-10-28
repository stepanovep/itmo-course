package module1.arrays;

import java.util.Arrays;
import java.util.Scanner;

import static module1.utils.ArraysUtils.generateArray;
import static module1.utils.ArraysUtils.printArray;

/**
 * @author Egor Stepanov
 * @since 17/10/2017.
 */
public class ArrayTasks {

    private static final double EPS = 1e-6;

    private static void task1() {
        int[] a = new int[10];
        for (int i=0; i < 10; i++) {
            a[i] = 2*(i+1);
        }

        for (int i : a) {
            System.out.print(i);
            System.out.print(' ');
        }

        System.out.println();

        for (int i: a) {
            System.out.println(i);
        }
    }

    private static void task2() {
        int[] a = new int[50];
        for (int i = 0; i < 50; i++) {
            a[i] = i*2 + 1;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 49; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
    }

    private static void task3() {
        int N = 15;
        int a[] = generateArray(N, 0, 9);
        int oddCount = 0;

        for (int i = 0; i < N; i++) {
            if ((a[i] & 1) != 0)
                oddCount++;
        }

        printArray(a);
        System.out.println("Odd count = " + oddCount);
    }

    private static void task4() {
        int N = 8;
        int a[] = generateArray(N, 1, 10);

        printArray(a);

        for (int i = 1; i < a.length; i+=2) {
            a[i] = 0;
        }

        printArray(a);
    }

    private static void task5() {
        int N = 5;
        int a[] = generateArray(N, 0, 5);
        int b[] = generateArray(N, 0, 5);

        printArray(a);
        printArray(b);

        double aAvg = Arrays.stream(a).average().orElse(Double.NaN);
        double bAvg = Arrays.stream(b).average().orElse(Double.NaN);

        System.out.println("A average = " + aAvg);
        System.out.println("B average = " + bAvg);

        if (aAvg > bAvg) {
            System.out.println("Average of array A is greater than B");
        } else if (Math.abs(aAvg - bAvg) < EPS) {
            System.out.println("Averages are equal");
        } else {
            System.out.println("Average of array B is greater than A");
        }
    }

    private static void task6() {
        int N = 4;
        int[] a = generateArray(N, 10, 99);

        boolean isMonotonic = true;
        for (int i = 1; i < N; i++) {
            if (a[i] <= a[i-1]) {
                isMonotonic = false;
            }
        }

        printArray(a);
        System.out.println("Monotonic ? " + (isMonotonic ? "Yes" : "No"));
    }

    private static void task7() {
        int N = 20;
        int fibo[] = new int[N];
        fibo[0] = fibo[1] = 1;

        for (int i = 2; i < N; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        printArray("Fibonacci sequence", fibo);
    }

    private static void task8() {
        int N = 12;
        int a[] = generateArray(N, -15, 15);

        int max = Integer.MIN_VALUE;
        int max_index = -1;
        for (int i = 0; i < N; i++) {
            if (a[i] >= max) {
                max = a[i];
                max_index = i;
            }
        }
        printArray("Array", a);
        System.out.println("Max element is " + max + "; at position = " + max_index);
    }

    private static void task9() {
        int N = 10;
        int a[] = generateArray(N, 1, 9);
        int b[] = generateArray(N, 1, 9);

        double c[] = new double[N];
        int intCount = 0;

        for (int i = 0; i < N; i++) {
            c[i] = (double) a[i] / b[i];

            if (Math.abs(c[i] - (int)c[i]) < EPS) {
                intCount++;
            }
        }

        printArray(" First array", a);
        printArray("Second array", b);
        System.out.println("Ratio array: " + Arrays.toString(c));
        System.out.println("int values count in ration array = " + intCount);
    }

    private static void task10() {
        int N = 11;
        int[] a = generateArray(N, -1, 1);

        int minusOneCount = 0;
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < N; i++) {
            switch (a[i]) {
                case -1:
                    minusOneCount++;
                    break;
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                default:
                    System.out.println("Something is broken! Generated value " + a[i]);
            }
        }
        printArray("Generated array", a);

        if (minusOneCount > zeroCount && minusOneCount > oneCount) {
            System.out.println("-1");
        } else if (zeroCount > minusOneCount && zeroCount > oneCount) {
            System.out.println("0");
        } else if (oneCount > minusOneCount && oneCount > zeroCount) {
            System.out.println("+1");
        } else {
            System.out.println("Bullshit");
        }
    }

    private static void task11() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        boolean stop = true;
        do {
            System.out.println("Enter a positive even value:");
            n = in.nextInt();
            if (n > 0 && (n & 1) == 0)
                stop = false;
        } while(stop);

        int[] a = generateArray(n, -5, 5);
        printArray("Array", a);
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n/2; i++) {
            sum1 += a[i];
            sum2 += a[n-1-i];
        }

        System.out.println("left sum = " + sum1);
        System.out.println("right sum = " + sum2);
    }

    private static void task12() {
        int N = 12;
        int a[];
        boolean isZero, isBalanced, isArrayChaotic;
        int tries = 0;
        do {
            a = generateArray(12, -10, 10);
            isZero = Arrays.stream(a)
                    .filter(i -> i ==0)
                    .count() > 0;

            long negativeCount = Arrays.stream(a)
                    .filter(i -> i < 0)
                    .count();

            long positiveCount = Arrays.stream(a)
                    .filter(i -> i > 0)
                    .count();

            isBalanced = negativeCount == positiveCount;

            isArrayChaotic = isChaotic(a);

            tries++;
        } while(isZero || !isBalanced || !isArrayChaotic);

        printArray("Generated array", a);
        System.out.println("Tries: " + tries);
    }

    private static boolean isChaotic(int[] a) {
        boolean allHalfPositive = true;
        int n = a.length;
        for (int i = 0; i < n/2; i++) {
            if (a[i] < 0) {
                allHalfPositive = false;
                break;
            }
        }

        boolean allHalfNegative = true;
        for (int i = n/2; i < n; i++) {
            if (a[i] > 0) {
                allHalfNegative = false;
                break;
            }
        }

        boolean isAlternation = true;
        for (int i = 1; i < n; i++) {
            if (a[i] * a[i-1] >= 0) {
                isAlternation = false;
                break;
            }
        }

        return !allHalfNegative && !allHalfPositive && !isAlternation;
    }

    private static void task13() {
        Scanner in = new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter n > 3");
            n = in.nextInt();
        } while(n <= 3);

        int[] a = generateArray(n, 0, n);
        printArray("Generated array", a);

        int[] evens = Arrays.stream(a)
                .filter(i -> (i & 1) == 0)
                .toArray();
        printArray("Array of even values", evens);
    }
}
