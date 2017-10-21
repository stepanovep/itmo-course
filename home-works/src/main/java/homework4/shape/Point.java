package homework4.shape;

/**
 * @author Egor Stepanov
 * @since 19/10/2017.
 */
public class Point {

    private final double x;
    private final double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(double x, double y) {
        return new Point(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point plus(double x, double y) {
        return new Point(this.x + x, this.y + y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.getX() - p2.getX())*(p1.getX() - p2.getX()) +
                         (p1.getY() - p2.getY())*(p1.getY() - p2.getY()));
    }
}
