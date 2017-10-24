package homework6;

/**
 * Интерфейс - список элементов
 *
 * @author Egor Stepanov
 * @since  24-10-2017.
 */
public interface List<T> {
    /**
     * Добавить элемент в список
     */
    void add(int idx, T obj);

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
