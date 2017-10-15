package homework2.package3;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Egor Stepanov
 * @since 14/10/2017.
 */
public class Tasks_1_4 {
    public static void main(String[] args) {
        System.out.println("Task1: ");
        doTask1();

        System.out.println("Task2: ");
        doTask2();

        System.out.println("Task3: ");
        doTask3();

        System.out.println("Task4: ");
        doTask4();

    }

    private static void doTask1() {
        IntStream.iterate(1000, i -> i+3)
                .limit(10_000)      // пришлось добавить этот костыль.
                                    // filter оказывается не делает стрим конечным
                .filter(n -> n < 10_000)
                .forEach(Tasks_1_4::print);

        printEmptyLines();
    }

    private static void doTask2() {
        IntStream.iterate(1, i -> i+2)
                .limit(55)
                .forEach(Tasks_1_4::print);

        printEmptyLines();
    }

    private static void doTask3() {
        IntStream.iterate(90, i -> i-5)
                .limit(100)
                .filter(n -> n >= 0)
                .forEach(Tasks_1_4::print);

        printEmptyLines();
    }

    private static void doTask4() {
        Stream.iterate(2, i -> i*2)
                .limit(20)
                .forEach(Tasks_1_4::print);

        printEmptyLines();
    }

    private static void print(int n) {
        System.out.print(n);
        System.out.print(' ');
    }

    private static void printEmptyLines() {
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
