package homework5.shape;

import homework4.shape.Point;

/**
 * @author Egor Stepanov
 * @since 21/10/2017.
 */
public class Square extends Rectangle {

    private final Point downLeftPoint;
    private final double a;

    public Square(Point downLeftPoint, double a) {
        super(downLeftPoint, downLeftPoint.plus(a, a));
        this.downLeftPoint = downLeftPoint;
        this.a = a;
    }

    @Override
    public Point getDownLeftPoint() {
        return downLeftPoint;
    }

    public double getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Square{" +
                "downLeftPoint=" + downLeftPoint +
                ", a=" + a +
                '}';
    }
}
