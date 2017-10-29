package module1.collections;

import org.junit.Assert;
import org.junit.Test;

public class CloneTest {

    @Test
    public void arrayListCloneTest() {
        List<String> list = new ArrayList<>(10);
        list.add("123");
        list.add("456");

        List<String> cloneList = list.clone();
        Assert.assertTrue(list.equals(cloneList));

        list.remove(0);
        Assert.assertFalse(list.equals(cloneList));
    }

    @Test
    public void linkedListCloneTest() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        List<Integer> cloneList = list.clone();
        Assert.assertTrue(list.equals(cloneList));

        list.remove(0);
        Assert.assertFalse(list.equals(cloneList));
    }
}
