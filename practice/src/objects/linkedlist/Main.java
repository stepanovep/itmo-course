package objects.linkedlist;

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
        sortedLinkedList.add(8);
        sortedLinkedList.add(4);
        sortedLinkedList.add(2);
        sortedLinkedList.add(20);

        Node node = sortedLinkedList.get(4);
        System.out.println("get: " + node);
        sortedLinkedList.remove(4);

        System.out.println(sortedLinkedList.getHead());
    }
}
