package module1.shape;

/**
 * @author Egor Stepanov
 * @since 21/10/2017.
 */
public class Ellipse implements Shape {

    // Фокусы эллипса
    private final Point f1;
    private final Point f2;

    // Константа, для которого |F1M| + |F2M| == |2a|
    // Большой радиус эллипса
    private final double a;

    // Малый радиус эллипса
    private final double b;

    // Экцентреситет
    private double e;

    public Ellipse(Point f1, Point f2, double a) {
        this.f1 = f1;
        this.f2 = f2;
        this.a = a;
        this.e = Point.distance(f1, f2) / (2*a);
        this.b = a * Math.sqrt(1 - e*e);
    }

    public Point getF1() {
        return f1;
    }

    public Point getF2() {
        return f2;
    }

    public double getA() {
        return a;
    }

    @Override
    public double getArea() {
        return Math.PI*a*b;
    }

    @Override
    public double getPerimeter() {
        return 4 * (Math.PI * a * b - (a-b)*(a-b)) / (a+b);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "f1=" + f1 +
                ", f2=" + f2 +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
