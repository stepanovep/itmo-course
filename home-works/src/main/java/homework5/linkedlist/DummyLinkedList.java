package homework5.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Egor Stepanov
 * @since  18/10/2017.
 */
public class DummyLinkedList implements CustomLinkedList {

    private static final Logger log = LoggerFactory.getLogger(DummyLinkedList.class);

    private Node head;

    public DummyLinkedList(Object value) {
        this.head = new Node(value, null);
    }

    public DummyLinkedList() {
        this.head = new Node(0, null);
    }

    public Node getHead() {
        return head;
    }

    public void add(Object x) {
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
    public Object remove(int i) {
        if (i < 1) {
            log.info("cannot remove head Node");
            return head.getValue();
        }
        int k = 1;
        Node last = head;
        Node current = head.getNext();
        while (current != null) {
            if (k == i) {
                last.setNext(current.getNext());
                log.info("removed: {}", current);
                return current.getValue();
            } else {
                last = current;
                current = current.getNext();
                k++;
            }
        }
        log.info("not enough Nodes");
        return head.getValue();
    }
}
