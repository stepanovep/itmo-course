package module1.random.package1;

import java.util.Scanner;

/**
 * Корни квадратного уравнения
 *
 * @author Egor Stepanov
 * @since 13/10/2017.
 */
public class Task3 {

    private static final double EPS = 1e-6;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        System.out.println(String.format("Given equation: %.2fx^2 + %.2fx + %.2f", a, b, c));
        double d = b*b - 4*a*c;
        if (d < 0) {
            System.out.println("No roots of equation");
        } else if (Math.abs(d) < EPS) {
            double root = -b / (2*a);
            System.out.println(String.format("The equation has one root: %.2f", root));
        } else {
            double root1 = (-b + Math.sqrt(d)) / (2*a);
            double root2 = (-b - Math.sqrt(d)) / (2*a);
            System.out.println(String.format(
                    "The equation has two roots: root1=%.2f,  root2=%.2f", root1, root2));
        }
    }
}
