package module1.accumulator.operation;

/**
 * @author Egor Stepanov
 * @since 20/10/2017.
 */
public class Multiply implements Operation {
    @Override
    public int doOperation(int x, int y) {
        return x * y;
    }
}
