package homework4.linkedlist;

/**
 * @author Egor Stepanov
 * @since  18/10/2017.
 */
public interface CustomLinkedList {

    /**
     * Добавить узел в список
     */
    void add(int value);

    /**
     * Получить узел по индексу
     */
    Node get(int idx);

    /**
     * Удалить из списка узел по индексу
     * @return значение удаляемого узла
     */
    int remove(int idx);
}
