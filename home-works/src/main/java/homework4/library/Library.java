package homework4.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Egor Stepanov
 * @since 19/10/2017.
 */
public class Library {

    private static final Logger log = LoggerFactory.getLogger(Library.class);

    private final int maxCapacity;
    private Map<Book, Integer> books;

    private int currentSize;
    private boolean isFull;

    Library(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.books = new HashMap<>();
        this.currentSize = 0;
        this.isFull = false;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    Map<Book, Integer> getBooks() {
        return books;
    }

    int getCurrentSize() {
        return currentSize;
    }

    boolean isFull() {
        return isFull;
    }

    boolean hasSpace() {
        return !isFull;
    }

    void put(Book book, int quantity) {
        if (isFull) {
            log.info("Cannot put new books: the library is full");
            return;
        }
        int availableToAdd = Integer.min(quantity, maxCapacity - currentSize);
        if (!books.containsKey(book)) {
            books.put(book, availableToAdd);
        } else {
            books.put(book, books.get(book) + availableToAdd);
        }
        currentSize += availableToAdd;

        if (currentSize >= maxCapacity) {
            log.info("The library is full. currentSize={}", currentSize);
            isFull = true;
        } else {
            log.info("new books in the library: book={}, quantity={}", book, quantity);
            log.info("current size of the library: {}", currentSize);
        }
    }

    void get(Book book, int quantity) {
        if (books.containsKey(book)) {
            int booksToRemove = Integer.min(quantity, books.get(book));

            books.put(book, books.get(book) - booksToRemove);
            currentSize -= booksToRemove;

            log.info("some books was removed from the library: book={}, quantity", book, quantity);
            log.info("current size of the library: {}", currentSize);
            isFull = false;
        } else {
            log.info("there is no such book: {}", book);
        }
    }
}
