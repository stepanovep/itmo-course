package module1.collections;

/**
 * Интерфейс - очередь
 *
 * @author Egor Stepanov
 * @since  24-10-2017.
 */
public interface Queue<T> {
    /**
     * Добавить элемент в очередь (в конец)
     */
    void add(T obj);

    /**
     * Вытащить первый элемент очереди (из начала)
     */
    T poll();

    /**
     * Вернуть первый элемент очереди
     */
    T peek();
}
