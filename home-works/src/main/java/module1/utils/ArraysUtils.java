package module1.utils;

import static module1.utils.RandomUtils.generateInt;

/**
 * @author Egor Stepanov
 * @since 17/10/2017.
 */
public class ArraysUtils {

    /**
     * Сгенерировать случайный массив из случайных целых чисел
     *
     * @param n размер массива
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public static int[] generateArray(int n, int min, int max) {
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = generateInt(min, max);
        }

        return a;
    }

    /**
     * Сгенерировать двумерный массив из случайных целых чисел
     */
    public static int[][] generate2dArray(int n, int m, int min, int max) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = generateArray(m, min, max);
        }

        return a;
    }

    /**
     * Вывести массив в стандартный вывод с префиксом
     */
    public static void printArray(String message, int ... a) {
        if (message != null) {
            System.out.println(message + ":");
        }
        System.out.print("[ ");
        for (int i: a) {
            System.out.print(i);
            System.out.print('\t');
        }
        System.out.println(']');
    }

    /**
     * Вывести массив в стандартный вывод
     */
    public static void printArray(int ... a) {
        printArray(null, a);
    }

    /**
     * Вывести двумерный массив в стандартный вывод
     */
    public static void printArray(int[][] a) {
        for (int[] array : a) {
            printArray(array);
        }
        System.out.println();
    }
}
