package module1.random.package2;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Egor Stepanov
 * @since 13/10/2017.
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        List<Integer> list = Arrays.asList(a, b, c);
        Collections.sort(list);
        System.out.println(list);
    }
}
