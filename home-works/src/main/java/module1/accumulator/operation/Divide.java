package module1.accumulator.operation;

/**
 * @author Egor Stepanov
 * @since 20/10/2017.
 */
public class Divide implements Operation {

    @Override
    public int doOperation(int x, int y) {
        if (y == 0) {
            return 0;
        }
        return x / y;
    }
}
