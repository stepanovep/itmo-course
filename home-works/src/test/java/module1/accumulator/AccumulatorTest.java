package module1.accumulator;

import module1.accumulator.operation.Divide;
import module1.accumulator.operation.Minus;
import module1.accumulator.operation.Multiply;
import module1.accumulator.operation.Plus;
import module1.accumulator.operation.Power;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Egor Stepanov
 * @since 20/10/2017.
 */
public class AccumulatorTest {

    @Test
    public void operationsTest() {
        // Plus:
        Accumulator accPlus = new Accumulator(1, new Plus());
        accPlus.accumulate(5);
        Assert.assertEquals(accPlus.getValue(), 6);

        // Minus:
        Accumulator accMinus = new Accumulator(100, new Minus());
        accMinus.accumulate(50);
        Assert.assertEquals(accMinus.getValue(), 50);

        // Multiply:
        Accumulator accMult = new Accumulator(2, new Multiply());
        accMult.accumulate(3);
        Assert.assertEquals(accMult.getValue(), 6);

        // Divide:
        Accumulator accDiv = new Accumulator(100, new Divide());
        accDiv.accumulate(50);
        Assert.assertEquals(accDiv.getValue(), 2);

        // Power:
        Accumulator accPower = new Accumulator(2, new Power());
        accPower.accumulate(10);
        Assert.assertEquals(accPower.getValue(), 1024);
    }
}
