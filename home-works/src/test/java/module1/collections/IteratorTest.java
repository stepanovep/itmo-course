package module1.collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Egor Stepanov
 * @since  26-10-2017.
 */
@RunWith(Parameterized.class)
public class IteratorTest {

    private List<Integer> list;

    public IteratorTest(List<Integer> list) {
        this.list = list;
    }

    private static final int N = 10;

    @Test
    public void iteratorTest() {
        for (int i = 0; i < N; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        Assert.assertTrue(iterator.hasNext());

        for (int i = 0; i < N-1; i++) {
            iterator.next();
        }
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(iterator.next().intValue(), N-1);

        Assert.assertFalse(iterator.hasNext());
        Assert.assertNull(iterator.next());

        for (int val: list) {
            System.out.println(val);
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new LinkedList<>()},
                new Object[]{new ArrayList<>(N)}
        );
    }
}
