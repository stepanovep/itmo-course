package homework6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.arraycopy;

/**
 * Реализация структук данных Queue, Stack и List
 * через обычный массив
 *
 * @author Egor Stepanov
 * @since  24-10-2017.
 */
public final class ArrayList<T> implements Queue<T>, Stack<T>, List<T> {

    private static final Logger log = LoggerFactory.getLogger(ArrayList.class);

    private Object[] list;
    private int capacity;
    private int size;

    ArrayList(int initialCapacity) {
        this.capacity = initialCapacity;
        this.list = new Object[initialCapacity];
        size = 0;
    }


    // ---------- List -------------
    @Override
    public void add(int idx, T obj) {
        if (idx < 0 || idx > size) {
            log.info("index: {} - should be in range [0, {}].", idx, size);
            return;
        }
        if (size == capacity) {
            extendCapacity();
        }
        for (int i = size-1; i >= idx; i++) {
            list[i+1] = list[i];
        }
        list[idx] = obj;
        size++;
        log.info("[list]: Element {} added in position {}", obj, idx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int idx) {
        return (T) list[idx];
    }

    @Override
    public T remove(int idx) {
        if (idx < 0 || idx >= size) {
            log.info("index: {} - should be in range [0, {}].", idx, size-1);
            return null;
        }
        T elementToRemove = get(idx);
        for (int i = idx; i < size-1; i++) {
            list[i] = list[i+1];
        }
        list[size-1] = null;
        size--;
        log.info("[list]: Removed element: {}", elementToRemove);
        return elementToRemove;
    }

    @Override
    public int size() {
        return size;
    }


    // ---------- Queue -------------
    @Override
    public void add(T obj) {
        if (size == capacity) {
            extendCapacity();
        }
        list[size] = obj;
        size++;
        log.info("[queue]: Added element: {}", obj);
    }

    @Override
    public T poll() {
        if (size == 0) {
            log.info("Queue is empty: no element to poll");
            return null;
        }
        T firstElement = get(0);
        for (int i = 0; i < size-1; i++) {
            list[i] = list[i+1];
        }
        list[size-1] = null;
        size--;
        log.info("[queue]: Polled element: {}", firstElement);
        return firstElement;
    }


    // ---------- Stack -------------
    @Override
    public void push(T obj) {
        if (size == capacity) {
            extendCapacity();
        }
        list[size] = obj;
        size++;
        log.info("[stack]: Pushed element: {}", obj);
    }

    @Override
    public T pop() {
        if (size == 0) {
            log.info("Stack is empty: no element to pop");
            return null;
        }
        T topElement = get(size-1);
        list[size-1] = null;
        size--;
        log.info("[stack]: Popped element: {}", topElement);
        return topElement;
    }


    private void extendCapacity() {
        Object[] tmp = new Object[size];
        arraycopy(list, 0, tmp, 0, size);

        list = new Object[2*size];
        capacity = 2*size;
        arraycopy(tmp, 0, list, 0, size);

        log.info("capacity of list is doubled; new capacity = {}", capacity);
    }
}
