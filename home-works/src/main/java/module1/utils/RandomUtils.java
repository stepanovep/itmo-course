package module1.utils;

import java.util.Random;

/**
 * @author Egor Stepanov
 * @since 18/10/2017.
 */
public class RandomUtils {

    private static Random rnd = new Random();

    public static int generateInt(int minBound, int maxBound) {
        return minBound + rnd.nextInt(maxBound - minBound + 1);
    }
}
