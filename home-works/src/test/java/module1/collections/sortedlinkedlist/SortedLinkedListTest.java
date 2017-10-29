package module1.collections.sortedlinkedlist;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Egor Stepanov
 * @since 18/10/2017.
 */
public class SortedLinkedListTest {

    @Test
    public static void sortedListTest() {
        SortedLinkedList list = new SortedLinkedList(1);
        list.add(7);
        list.add(3);
        list.add(5);

        Assert.assertEquals(list.get(0).getValue(), 1);
        Assert.assertEquals(list.get(1).getValue(), 3);
        Assert.assertEquals(list.get(2).getValue(), 5);
        Assert.assertEquals(list.get(3).getValue(), 7);
    }
}
