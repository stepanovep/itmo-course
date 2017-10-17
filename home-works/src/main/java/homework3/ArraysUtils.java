package homework3;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Egor Stepanov
 * @since 17/10/2017.
 */
public class ArraysUtils {

    /**
     * Сгенерировать случайный массив из целых чисел
     *
     * @param n размер массива
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public static int[] generateArray(int n, int min, int max) {
        Random rnd = new Random();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = min + rnd.nextInt(max-min+1);
        }

        return a;
    }

    /**
     * Вывести массив в стандартный вывод с префиксом
     */
    public static void printArray(String message, int ... a) {
        System.out.println(message + ": "+ Arrays.toString(a));
    }

    /**
     * Вывести массив в стандартный вывод
     */
    public static void printArray(int ... a) {
        System.out.println(Arrays.toString(a));
    }
}
