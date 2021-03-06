package module1.collections.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

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
    private int modCount = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    public ArrayList(int initialCapacity) {
        this.capacity = initialCapacity;
        this.list = new Object[initialCapacity];
        size = 0;
    }

    public ArrayList() {
        new ArrayList<>(DEFAULT_INITIAL_CAPACITY);
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
        modCount++;
        log.info("[list]: Element {} added in position {}", obj, idx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int idx) {
        if (idx < 0 || idx >= size) {
            log.info("index: {} - should be in range [0, {}].", idx, size-1);
            throw new IndexOutOfBoundsException();
        }
        return (T) list[idx];
    }

    @Override
    public T remove(int idx) {
        if (idx < 0 || idx >= size) {
            log.info("index: {} - should be in range [0, {}].", idx, size-1);
            return null;
        }
        T elementToRemove = get(idx);
        arraycopy(list, idx + 1, list, idx, size - 1 - idx);
        list[size-1] = null;
        size--;
        modCount++;
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
        modCount++;
        log.info("[queue]: Added element: {}", obj);
    }

    @Override
    public T poll() {
        if (size == 0) {
            log.info("Queue is empty: no element to poll");
            return null;
        }
        T firstElement = get(0);
        System.arraycopy(list, 1, list, 0, size - 1);
        list[size-1] = null;
        size--;
        log.info("[queue]: Polled element: {}", firstElement);
        return firstElement;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return get(0);
    }


    // ---------- Stack -------------
    @Override
    public void push(T obj) {
        if (size == capacity) {
            extendCapacity();
        }
        list[size] = obj;
        size++;
        modCount++;
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
        modCount++;
        log.info("[stack]: Popped element: {}", topElement);
        return topElement;
    }

    @Override
    public T top() {
        if (size == 0) {
            return null;
        }
        return get(size-1);
    }

    private void extendCapacity() {
        Object[] tmp = new Object[size];
        arraycopy(list, 0, tmp, 0, size);

        list = new Object[2*size];
        capacity = 2*size;
        arraycopy(tmp, 0, list, 0, size);

        log.info("capacity of list is doubled; new capacity = {}", capacity);
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<T>() {
            int current_idx = 0;

            @Override
            public boolean hasNext() {
                return current_idx < size ;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (current_idx >= size) {
                    return null;
                }
                return (T) list[current_idx++];
            }
        };
    }

    @Override
    public int hashCode() {
        int result = size;
        for (int i = 0; i < size; i++) {
            T current = get(i);
            result += 31*result + (current != null ? current.hashCode() : 0) + i;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null || !(obj instanceof ArrayList)) {
            return false;
        }

        ArrayList<T> other = (ArrayList<T>) obj;
        if (size != other.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(this.get(i), other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<T> clone() {
        List<T> cloneList = new ArrayList<>(size);
        for (T current: this) {
            cloneList.add(current);
        }

        return cloneList;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Empty ArrayList";
        }
        StringBuilder stringBuilder = new StringBuilder("ArrayList: {");
        for (int i = 0; i < size-1; i++) {
            stringBuilder.append(get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.append(get(size-1));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public List<T> emptyList() {
        return new ArrayList<>(10);
    }
}
