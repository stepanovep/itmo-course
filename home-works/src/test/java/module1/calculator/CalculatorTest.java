package module1.calculator;

import org.junit.Test;
import org.testng.Assert;

/**
 * @author Egor Stepanov
 * @since  13-11-2017.
 */
public class CalculatorTest {

    @Test
    public void should_successfully_execute_commands() {
        Calculator calculator = new Calculator();

        calculator.execute("x = 10");
        Assert.assertEquals(calculator.getX(), 10);

        Assert.assertEquals(calculator.execute("5 + x"), 15);

        calculator.execute("y=20");
        Assert.assertEquals(calculator.execute("x+y"), 10+20);
        Assert.assertEquals(calculator.execute("x-y"), 10-20);
        Assert.assertEquals(calculator.execute("x*y"), 10*20);
        Assert.assertEquals(calculator.execute("y/x"), 20/10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception() {
        Calculator calculator = new Calculator();
        calculator.execute("5 = 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception2() {
        Calculator calculator = new Calculator();
        calculator.execute("x == 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception3() {
        Calculator calculator = new Calculator();
        calculator.execute("yy + 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception4() {
        Calculator calculator = new Calculator();
        calculator.execute("x + 5 + 4");
    }
}
