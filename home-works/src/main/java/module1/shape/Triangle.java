package module1.shape;

/**
 * @author Egor Stepanov
 * @since 21/10/2017.
 */
public class Triangle implements Shape {

    private final Point p1;
    private final Point p2;
    private final Point p3;

    private final double a;
    private final double b;
    private final double c;

    Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        a = Point.distance(p2, p3);
        b = Point.distance(p1, p3);
        c = Point.distance(p1, p2);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
