package homework6;

/**
 * Интерфейс - стэк
 *
 * @author Egor Stepanov
 * @since  24-10-2017.
 */
public interface Stack<T> {
    /**
     * Положить элемент в стэк (в конец)
     */
    void push(T obj);

    /**
     * Вытащить элемент (из конца)
     */
    T pop();
}
