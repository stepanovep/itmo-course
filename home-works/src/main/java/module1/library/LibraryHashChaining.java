package module1.library;

import module1.collections.list.LinkedList;
import module1.collections.list.List;
import module1.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Реализация библиотеки с хешированием
 * (прямое связывание при коллизии)
 *
 * @author Egor Stepanov
 * @since  27-10-2017.
 */
public class LibraryHashChaining implements Library {

    private static final Logger log = LoggerFactory.getLogger(LibraryHashChaining.class);

    private int hashCapacity;       //todo расширять хэш при достижении фиксированного заполнения
    private int maxSize;
    private int size;
    private boolean isFull;

    private List<Book>[] hashell;
    public LibraryHashChaining(int initialHashCapacity, int maxSize) {
        this.hashCapacity = initialHashCapacity;
        this.maxSize = maxSize;
        this.size = 0;
        this.isFull = false;
        this.hashell = new List[initialHashCapacity];

        for (int i = 0; i < initialHashCapacity; i++) {
            hashell[i] = new LinkedList<>();            // по-идее, нужно бы что-то типа static List.emptyList();
        }
    }

    @Override
    public int addBooks(Book book, int quantity) {
        if (isFull) {
            log.info("The library is full - cannot add new books");
            return 0;
        }
        int hashIndex = Math.abs(book.hashCode()) % hashCapacity;
        Book foundBook = ListUtils.get(book, hashell[hashIndex]);
        int availableToAdd = Math.min(maxSize - size, quantity);
        if (foundBook != null) {
            foundBook.setQuantity(foundBook.getQuantity() + availableToAdd);
        } else {
            book.setQuantity(availableToAdd);
            hashell[hashIndex].add(book);
        }
        size += availableToAdd;
        if (size == maxSize) {
            log.info("The library gets full - reached max size: {}", maxSize);
            isFull = true;
        }
        return availableToAdd;
    }

    @Override
    public int getBooks(Book book, int quantity) {
        int hashIndex = Math.abs(book.hashCode()) % hashCapacity;
        Book foundBook = ListUtils.get(book, hashell[hashIndex]);
        if (foundBook != null) {
            int availableToGet = Math.min(foundBook.getQuantity(), quantity);
            foundBook.setQuantity(foundBook.getQuantity() - availableToGet);
            size -= availableToGet;
            if (availableToGet > 0) {
                isFull = false;
            }
            return availableToGet;
        } else {
            log.info("The book not found: {}", book);
            return 0;
        }
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
