package homework6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    LinkedList() {
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
    public void add(int idx, T value) {
        if (idx < 0 || idx > size) {
            log.info("index: {} - should be in range [0, {}].", idx, size);
            return;
        }
        int k = 0;
        Node last = head;
        Node current = last.getNext();
        while (k < idx) {
            last = current;
            current = current.getNext();
            k++;
        }
        Node newNode = new Node(value, current, last);
        if (current == null) {
            tail = newNode;
        }
        last.setNext(newNode);
        size++;
        log.info("[list]: Node {} added in position {}", newNode, idx);
    }

    @Override
    @SuppressWarnings("unchecked")
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
        log.info("[queue]: Added node: {}", newNode);
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


    // -------- Node ----------
    public final class Node {
        private T value;
        private Node next;
        private Node last;

        public Node(T value, Node next, Node last) {
            this.value = value;
            this.next = next;
            this.last = last;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getLast() {
            return last;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
            if (next != null) {
                next.setLast(this);
            }
        }

        public void setLast(Node last) {
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
