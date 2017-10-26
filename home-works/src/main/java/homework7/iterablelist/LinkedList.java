package homework7.iterablelist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * Реализация структук данных Queue, Stack и List
 * через двухсвязный список
 *
 * @author Egor Stepanov
 * @since  24-10-2017.
 */
public class LinkedList<T> implements Queue<T>, Stack<T>, List<T> {

    private static final Logger log = LoggerFactory.getLogger(ArrayList.class);

    /**
     * Абстрактный элемент списка. (-1-ый элемент)
     * Инициализируется вместе со списокм, всегда присутствует, нельзя удалить.
     */
    private Node head;

    /**
     * Последний элемент списка.
     */
    private Node tail;

    /**
     * Количество элементов в списке
     */
    private int size;

    public LinkedList() {
        this.head = new Node(null, null, null);
        tail = null;
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    // ---------- List -------------
    @Override
    public T get(int idx) {
        if (idx < 0 || idx > size-1) {
            log.info("index: {} - should be in range [0, {}].", idx, size-1);
            return null;
        }
        int k = 0;
        Node current = head.getNext();
        while (k < idx) {
            current = current.getNext();
            k++;
        }
        return current.getValue();
    }

    @Override
    public T remove(int idx) {
        if (idx < 0 || idx > size-1) {
            log.info("index: {} - should be in range [0, {}].", idx, size-1);
            return null;
        }
        int k = 0;
        Node last = head;
        Node current = last.getNext();
        while (k < idx) {
            last = current;
            current = current.getNext();
            k++;
        }
        last.setNext(current.getNext());
        size--;
        log.info("Removed node: {}", current);
        return current.getValue();
    }

    @Override
    public int size() {
        return size;
    }


    // ---------- Queue -------------
    @Override
    public void add(T value) {
        Node newNode = addpush(value);
        log.info("Added node: {}", newNode);
    }

    @Override
    public T poll() {
        if (tail == null) {
            log.info("Queue is empty - nothing to poll");
            return null;
        }
        Node polledNode = head.getNext();
        head.setNext(polledNode.getNext());
        size--;
        log.info("[queue]: Polled node: {}", polledNode);
        return polledNode.getValue();
    }

    @Override
    public T peek() {
        if (head.getNext() == null) {
            return null;
        }
        return head.getNext().getValue();
    }


    // ---------- Stack -------------
    @Override
    public void push(T value) {
        Node newNode = addpush(value);
        log.info("[stack]: Pushed node: {}", newNode);
    }

    @Override
    public T pop() {
        if (tail == null) {
            log.info("Stack is empty - nothing to pop");
            return null;
        }
        Node poppedNode = tail;
        tail = poppedNode.getLast();
        tail.setNext(null);
        size--;
        log.info("[stack]: Popped node: {}", poppedNode);
        return poppedNode.getValue();
    }

    @Override
    public T top() {
        if (tail == null) {
            return null;
        }
        return tail.getValue();
    }


    private Node addpush(T value) {
        Node newNode = new Node(value, null, tail);
        if (tail == null) {
            tail = newNode;
            head.setNext(tail);
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return newNode;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head.getNext();

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    return null;
                }
                T currentValue = current.getValue();
                current = current.getNext();
                return currentValue;
            }
        };
    }

    // -------- Node ----------
    public final class Node {
        private T value;
        private Node next;
        private Node last;

        Node(T value, Node next, Node last) {
            this.value = value;
            this.next = next;
            this.last = last;
        }

        public T getValue() {
            return value;
        }

        Node getNext() {
            return next;
        }

        Node getLast() {
            return last;
        }

        public void setValue(T value) {
            this.value = value;
        }

        void setNext(Node next) {
            this.next = next;
            if (next != null) {
                next.setLast(this);
            }
        }

        void setLast(Node last) {
            this.last = last;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
