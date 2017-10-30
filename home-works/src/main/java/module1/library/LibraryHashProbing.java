package module1.library;

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

    private Book[] books;
    private int hashSize;

    public LibraryHashProbing(int initialHashSize, int maxSize) {
        this.maxSize = maxSize;
        this.books = new Book[initialHashSize];
        this.hashSize = initialHashSize;
        this.size = 0;
        this.isFull = false;
    }

    @Override
    public int addBooks(Book book, int quantity) {
        int hashIndex = Math.abs(book.hashCode()) % hashSize;

        while (books[hashIndex] != null && !books[hashIndex].equals(book)) {
            hashIndex = (hashIndex+1) % hashSize;
        }
        int beforeQuantity = books[hashIndex] == null ? 0 : books[hashIndex].getQuantity();
        int availableToAdd = Math.min(maxSize - size, quantity);

        books[hashIndex] = new Book(book, beforeQuantity + availableToAdd);
        size += availableToAdd;

        if (size == maxSize) {
            isFull = true;
            log.info("The library gets full. size = {}", maxSize);
        }

        return availableToAdd;
    }

    @Override
    public int getBooks(Book book, int quantity) {
        int hashIndex = Math.abs(book.hashCode()) % hashSize;

        while (books[hashIndex] != null && !books[hashIndex].equals(book)) {
            hashIndex = (hashIndex + 1) % hashSize;
            if (hashIndex == hashSize) {
                log.info("The library is full. Cannot add new books");
                return 0;
            }
        }

        if (books[hashIndex] == null) {
            log.info("There is no such book in the library: {}", book);
            return 0;
        }

        int beforeQuantity = books[hashIndex].getQuantity();
        int availableToGet = Math.min(beforeQuantity, quantity);

        books[hashIndex] = new Book(book, beforeQuantity - quantity);
        size -= availableToGet;

        if (availableToGet > 0) {
            isFull = false;
        }

        return availableToGet;
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
