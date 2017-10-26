package homework7.iterablelist;

/**
 * Интерфейс - список элементов
 *
 * @author Egor Stepanov
 * @since  24-10-2017.
 */
public interface List<T> extends Iterable<T> {
    /**
     * Добавить элемент в список
     */
    void add(T obj);

    /**
     * Получить элемент по индексу
     */
    T get(int idx);

    /**
     * Удалить элемент из списка
     */
    T remove(int idx);

    /**
     * Получить количество элементов в списке
     */
    int size();
}
