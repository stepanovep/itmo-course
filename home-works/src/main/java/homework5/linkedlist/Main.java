package homework5.linkedlist;

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
    }
}
