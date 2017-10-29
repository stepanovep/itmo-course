package module1.collections;

import org.junit.Test;
import org.testng.Assert;

/**
 * @author Egor Stepanov
 * @since 29-10-2017.
 */
public class EqualsAndHashcodeTest {

    private static final int N = 10;

    @Test
    public void arrayListEqualsTest() {
        List<Integer> list1 = new ArrayList<>(N);
        List<Integer> list2 = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list1.add(i);
            list2.add(i);
        }

        Assert.assertTrue(list1.equals(list2));
        Assert.assertEquals(list1.hashCode(), list2.hashCode());

        list2.add(N);
        Assert.assertFalse(list1.equals(list2));
    }

    @Test
    public void linkedListEqualsTest() {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list1.add(i);
            list2.add(i);
        }

        Assert.assertTrue(list1.equals(list2));
        Assert.assertEquals(list1.hashCode(), list2.hashCode());

        list2.add(N);
        Assert.assertFalse(list1.equals(list2));
    }
}
