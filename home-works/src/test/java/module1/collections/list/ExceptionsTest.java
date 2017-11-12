package module1.collections.list;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;

/**
 * @author Egor Stepanov
 * @since  12-11-2017.
 */
@RunWith(Parameterized.class)
public class ExceptionsTest {

    private static final int N = 10;
    private List<String> list;

    public ExceptionsTest(List<String> list) {
        this.list = list;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_index_out_bound_exception() {
        list = list.emptyList();
        for (int i = 0; i < N; i++) {
            list.add(String.valueOf(i));
        }

        String blah = list.get(N);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void should_throw_concurrent_exception() {
        list = list.emptyList();
        for (int i = 0; i < N; i++) {
            list.add(String.valueOf(i));
        }

        for (String str: list) {
            list.add("123123123");
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new ArrayList<>()},
                new Object[]{new LinkedList<>()}
        );
    }
}
