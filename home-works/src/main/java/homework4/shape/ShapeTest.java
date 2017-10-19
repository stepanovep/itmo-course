package homework4.shape;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Egor Stepanov
 * @since 19/10/2017.
 */
public class ShapeTest {

    private static final double EPS = 1e-6;

    @Test
    public void testCircle() {
        // given: Окружность с центром в начале координат с радиусом 2
        Shape circle = new Circle(Point.of(0, 0), 2);
        // area should equal pi*r*r
        Assert.assertTrue(Math.abs(circle.getArea() - Math.PI*2*2) < EPS);
        // perimeter should equal 2*pi*r
        Assert.assertTrue(Math.abs(circle.getPerimeter() - 2*Math.PI*2) < EPS);
    }

    @Test
    public void testRectangle() {
        // given: Прямоугольник со сторонами 2 и 4
        Shape rectangle = new Rectangle(Point.of(0, 0), Point.of(2, 4));
        // then:
        Assert.assertEquals(rectangle.getArea(), 8.0);
        Assert.assertEquals(rectangle.getPerimeter(), 12.0);
    }

    @Test
    public void testTriangle() {
        // given: прямоугольный треугольник со сторонами (3, 4, 5) - Пифагор одобряет
        Shape triangle = new Triangle(Point.of(0, 0), Point.of(4, 0), Point.of(4, 3));
        // then:
        Assert.assertEquals(triangle.getArea(), 6.0);
        Assert.assertEquals(triangle.getPerimeter(), 12.0);
    }
}
