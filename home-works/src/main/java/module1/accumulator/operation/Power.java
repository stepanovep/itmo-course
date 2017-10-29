package module1.accumulator.operation;

/**
 * @author Egor Stepanov
 * @since 20/10/2017.
 */
public class Power implements Operation {
    @Override
    public int doOperation(int x, int y) {
        int p = 1;
        if (y < 0) {
            return x;
        }
        for (int i = 0; i < y; i++) {
            p *= x;
        }

        return p;
    }
}
