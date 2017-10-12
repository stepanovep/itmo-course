package homework1;


import org.testng.Assert;

/**
 * @author Egor Stepanov
 * @since  12/10/2017.
 */
public class HomeWork1 {

    public static void main(String[] args) {

        printQuotientAndMod(21, 8);

        Assert.assertEquals(getDigitsSum(123), 6);
        Assert.assertEquals(getDigitsSum(9999), 36);

        Assert.assertEquals(round(5.4), 5);
        Assert.assertEquals(round(5.6), 6);
        Assert.assertEquals(round(-10.25), -10);
        Assert.assertEquals(round(-10.75), -11);
    }

    /**
     * Вывести на экран результат
     * деления q на w с остатком
     */
    private static void printQuotientAndMod(int q, int w) {
        System.out.println("Quotient = " + q / w);
        System.out.println("Module = " + q % w);
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

    /**
     * Округлить вещественное число до ближайшего целого
     */
    private static long round(double f) {
        int preResult = (int) f;
        double d = f - preResult;
        if (d >= 0.5) {
            preResult++;
        } else if (d <= -0.5) {
            preResult--;
        }
        return preResult;
    }
}
