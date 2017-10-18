package objects.linkedlist;

/**
 * @author Egor Stepanov
 * @since  18/10/2017.
 */
public class DummyLinkedList implements CustomLinkedList {

    private Node head;

    public DummyLinkedList(int value) {
        this.head = new Node(value, null);
    }

    public DummyLinkedList() {
        this.head = new Node(0, null);
    }

    public Node getHead() {
        return head;
    }

    @Override
    public void add(int x) {
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node(x, null));
    }


    @Override
    public Node get(int i) {
        if (i < 1) {
            return head;
        }
        int k = 1;
        Node current = head.getNext();
        while(current != null) {
            if (k == i) {
                return current;
            } else {
                k++;
                current = current.getNext();
            }
        }
        return null;
    }

    @Override
    public int remove(int i) {
        if (i < 1) {
            System.out.println("cannot remove head Node");
            return head.getValue();
        }
        int k = 1;
        Node last = head;
        Node current = head.getNext();
        while (current != null) {
            if (k == i) {
                last.setNext(current.getNext());
                System.out.println("removed: " + current);
                return current.getValue();
            } else {
                last = current;
                current = current.getNext();
                k++;
            }
        }
        System.out.println("not enough Nodes");
        return head.getValue();
    }
}
