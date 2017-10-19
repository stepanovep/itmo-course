package homework4.shape;

/**
 * @author Egor Stepanov
 * @since 19/10/2017.
 */
public class Rectangle implements Shape {

    private final Point downLeftPoint;
    private final Point upperRightPoint;

    private double height;
    private double width;

    Rectangle(Point downLeftPoint, Point upperRightPoint) {
        this.downLeftPoint = downLeftPoint;
        this.upperRightPoint = upperRightPoint;

        height = Math.abs(upperRightPoint.getY() - downLeftPoint.getY());
        width = Math.abs(upperRightPoint.getX() - downLeftPoint.getX());
    }

    public Point getDownLeftPoint() {
        return downLeftPoint;
    }

    public Point getUpperRightPoint() {
        return upperRightPoint;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }
}
