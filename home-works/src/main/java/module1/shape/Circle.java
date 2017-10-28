package module1.shape;


/**
 * @author Egor Stepanov
 * @since 21/10/2017.
 */
public class Circle extends Ellipse {

    private final Point center;
    private final double radius;

    public Circle(Point center, double a) {
        super(center, center, a);
        this.center = center;
        radius = a;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
