package module1.library;

/**
 * Интерфейс - библиотека
 *
 * @author Egor Stepanov
 * @since 27-10-2017.
 */
public interface Library {

    /**
     * Добавить в библиотеку несколько экземпляров одной книги
     * @return количество добавленных книг
     */
    int addBooks(Book book, int quantity);

    /**
     * Взять из библиотеки несколько экземпляров одной книги
     * @return количество взятых книг
     */
    int getBooks(Book book, int quantity);

    /**
     * Вернуть текущее количество книг в библиотеке
     */
    int getSize();

    /**
     * Признак заполненности библиотеки
     */
    boolean isFull();

}
