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

    static Point of(double x, double y) {
        return new Point(x, y);
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.getX() - p2.getX())*(p1.getX() - p2.getX()) +
                         (p1.getY() - p2.getY())*(p1.getY() - p2.getY()));
    }
}
