package homework4.linkedlist;

/**
 * @author Egor Stepanov
 * @since 18/10/2017.
 */
public class SortedLinkedList implements CustomLinkedList {

    private Node head;

    public SortedLinkedList(int value) {
        this.head = new Node(value, null);
    }

    public Node getHead() {
        return head;
    }

    public void add(int value) {
        Node last = head;
        Node current = head.getNext();

        while (current != null && current.getValue() <= value) {
            last = current;
            current = current.getNext();
            if (current == null) {
                last.setNext(new Node(value, null));
                return;
            }
        }

        last.setNext(new Node(value, current));
    }

    public Node get(int idx) {
        if (idx < 1) {
            return head;
        }
        int k = 1;
        Node current = head.getNext();
        while(current != null) {
            if (k == idx) {
                return current;
            } else {
                k++;
                current = current.getNext();
            }
        }
        return null;
    }

    public int remove(int idx) {
        if (idx < 1) {
            System.out.println("cannot remove head Node");
            return head.getValue();
        }
        int k = 1;
        Node last = head;
        Node current = head.getNext();
        while (current != null) {
            if (k == idx) {
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
