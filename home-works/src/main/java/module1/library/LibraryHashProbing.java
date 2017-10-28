package module1.library;

import module1.collections.ArrayList;
import module1.collections.List;
import module1.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Реализация библиотеки с хешированием
 * (открытая адресация при коллизии)
 *
 * @author Egor Stepanov
 * @since  27-10-2017.
 */
public class LibraryHashProbing implements Library {

    private static final Logger log = LoggerFactory.getLogger(LibraryHashProbing.class);

    private int maxSize;
    private int size;
    private boolean isFull;

    private List<Book> books;

    public LibraryHashProbing(int initialHashCapacity, int maxSize) {
        this.maxSize = maxSize;
        this.books = new ArrayList<>(initialHashCapacity);
        this.size = 0;
        this.isFull = false;
    }

    @Override
    public int addBooks(Book book, int quantity) {
        int hashIndex = Math.abs(book.hashCode()) % size;

        while(books.get((hashIndex++) % size) == null);

        Book foundBook = ListUtils.get(book, books);
        if (foundBook == null) {
            books.add(hashIndex, new Book(book, quantity));
        } else {
            books.add(hashIndex, new Book(book, book.getQuantity() + quantity));
        }
        return quantity;
    }

    @Override
    public int getBooks(Book book, int quantity) {
        return 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return isFull;
    }
}
