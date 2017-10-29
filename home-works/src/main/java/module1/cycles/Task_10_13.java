package module1.cycles;

import java.util.stream.IntStream;

public class Task_10_13 {

    private static final int MIN = 1;
    private static final int MAX = 999_999;


    public static void main(String[] args) {

        long happyTicketsCount = IntStream.rangeClosed(MIN, MAX)
                .filter(Task_10_13::isHappyTicket)
                .count();
        System.out.println(String.format("10. Количество счастливых билетов в рулоне %06d-%06d:", MIN, MAX));
        System.out.println(happyTicketsCount + "\n");
        // 55251


        long invalidSignsCount = IntStream.rangeClosed(1, 50000)
                .mapToObj(Integer::toString)
                .filter(s -> s.contains("2"))
                .count();
        System.out.println("11. Количество ошибочных табличек: \n" + invalidSignsCount + "\n");
        // 23756


        long symmetricTimeCount = IntStream.rangeClosed(0, 2359)
                .filter(Task_10_13::isCorrectTime)
                .mapToObj(time -> String.format("%04d", time))
                .filter(Task_10_13::isPalindrome)
                .count();
        System.out.println("12. Время-палиндром в день встречается: \n" + symmetricTimeCount + "\n");
        // 16

        long unHappyNumbersCount = IntStream.rangeClosed(1, 100_000)
                .mapToObj(Integer::toString)
                .filter(s -> s.contains("4") || s.contains("13"))
                .count();
        System.out.println("13. Количество номеров, содержащих 4 или 13: \n" + unHappyNumbersCount + "\n");
        // 43840
    }

    private static boolean isHappyTicket(int n) {
        return getDigitsSum(n % 1000) ==  getDigitsSum(n / 1000);
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
     * Можно ли заданное число интерпретировать
     * как корректное время (в цифровых часах)
     */
    private static boolean isCorrectTime(int n) {
        if (n < 0 || n > 2359) {
            return false;
        }

        int hours = n / 100;
        int minutes = n % 100;

        return hours < 24 && minutes < 60;
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
