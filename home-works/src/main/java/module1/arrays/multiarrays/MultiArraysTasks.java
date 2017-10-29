package module1.arrays.multiarrays;

import module1.utils.RandomUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static module1.utils.ArraysUtils.generate2dArray;
import static module1.utils.ArraysUtils.printArray;

public class MultiArraysTasks {

    private static void task1() {
        int N = 8;
        int M = 5;
        int[][] a = generate2dArray(N, M, 10, 99);

        printArray(a);
    }

    private static void task2() {
        int N = 5;
        int M = 8;
        int[][] a = generate2dArray(N, M, -99, 99);

        printArray(a);

        int max = Arrays.stream(a).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);
        System.out.println(max);
    }

    private static void task3() {
        int N = 7;
        int M = 4;
        int[][] a = generate2dArray(N, M, -5, 5);
        printArray(a);

        int maxProd = Arrays.stream(a).mapToInt(x -> Arrays.stream(x)
                .reduce(1, (q, w) -> Math.abs(q*w)))
                .max().orElse(0);

        System.out.println(maxProd);
    }

    private static void task4() {
        int N = 6;
        int M = 7;
        int[][] a = generate2dArray(N, M, 0, 9);
        printArray(a);

        for (int i = 0; i < N; i++) {
            Arrays.sort(a[i]);
        }

        printArray(a);
    }

    private static void task5() {
        int N = 15;
        Set<String> prods = new HashSet<>();

        while (prods.size() < 15) {
            int x = RandomUtils.generateInt(1, 9);
            int y = RandomUtils.generateInt(1, 9);
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            prods.add(x + "" + y);
        }

        for (String prod: prods) {
            System.out.println(String.format("%c x %c", prod.charAt(0), prod.charAt(1)));
        }
    }

}
