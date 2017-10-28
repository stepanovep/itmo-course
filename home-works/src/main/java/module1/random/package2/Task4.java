package module1.random.package2;

import java.util.Random;

/**
 * Инженер Петров и его "часы"
 *
 * @author Egor Stepanov
 * @since 14/10/2017.
 */
public class Task4 {

    private static final int MAX_SECONDS = 28800;

    public static void main(String[] args) {
        Random rnd = new Random();

        int seconds = rnd.nextInt(MAX_SECONDS + 1);
        System.out.println("Generated time: " + seconds + " seconds");

        int hours = seconds / (60*60);

        if (hours >= 1) {
            System.out.println(String.format("Осталось %d часов", hours));
        } else {
            System.out.println("Осталось меньше часа");
        }
    }
}
