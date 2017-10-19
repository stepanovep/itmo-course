package homework4.shape;

/**
 * @author Egor Stepanov
 * @since 19/10/2017.
 */
public class Circle implements Shape {

    private final Point center;
    private final double radius;

    Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
