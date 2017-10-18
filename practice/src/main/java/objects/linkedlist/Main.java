package objects.linkedlist;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Egor Stepanov
 * @since 18/10/2017.
 */
public class Main {
    public static void main(String[] args) {
        DummyLinkedList dummyLinkedList = new DummyLinkedList(1);
        dummyLinkedList.add(10);
        dummyLinkedList.add(20);

        System.out.println(dummyLinkedList.remove(2));

        SortedLinkedList sortedLinkedList = new SortedLinkedList(1);
        sortedLinkedList.add(5);
        sortedLinkedList.add(10);
        sortedLinkedList.remove(1);
    }

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
