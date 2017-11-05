package module1.accumulator.lazy;

import module1.collections.list.LinkedList;
import org.junit.Test;
import org.testng.Assert;

import static module1.accumulator.lazy.LazyAccumulator.Operation;

/**
 * @author Egor Stepanov
 * @since  26-10-2017.
 */
public class LazyAccumulatorTest {

    @Test
    public void listAccumulatorTest() {
        LazyAccumulator lazyAccumulator = new LazyAccumulator(new LinkedList<>(), 0);
        lazyAccumulator.add(1, new Operation() {
            int argument;

            @Override
            public void setArgument(int y) {
                argument = y;
            }

            @Override
            public int apply(int x, int y) {
                return x + y;
            }

            @Override
            public int getArgument() {
                return argument;
            }
        });

        lazyAccumulator.add(3, new Operation() {
            int argument;
            @Override
            public void setArgument(int y) {
                argument = y;
            }

            @Override
            public int apply(int x, int y) {
                return x - y;
            }

            @Override
            public int getArgument() {
                return argument;
            }
        });

        Assert.assertEquals(lazyAccumulator.calculate(), 1 - 3);
    }

    @Test
    public void stackAccumulatorTest() {
        LazyAccumulatorStack accumulator = new LazyAccumulatorStack(new LinkedList<>(), 0);

        accumulator.add(20, new Operation() {
            private int argument;

            @Override
            public void setArgument(int y) {
                argument = y;
            }

            @Override
            public int apply(int x, int y) {
                return x + y;
            }

            @Override
            public int getArgument() {
                return argument;
            }
        });

        accumulator.add(10, new Operation() {
            private int argument;

            @Override
            public void setArgument(int y) {
                argument = y;
            }

            @Override
            public int getArgument() {
                return argument;
            }

            @Override
            public int apply(int x, int y) {
                return x-y;
            }
        });

        Assert.assertEquals(accumulator.calculate(), 20 - 10);
    }
}
