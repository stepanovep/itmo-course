package homework4.library;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Egor Stepanov
 * @since 19/10/2017.
 */
public class LibraryTest {

    @Test
    public void putBookTest() {
        // given:
        Library library = new Library(100);
        Book book1 = new Book("King", "It", 400);
        Book book2 = new Book("Martin", "GoT", 2000);

        // when:
        library.put(book1, 20);
        library.put(book2, 30);

        // then:
        Assert.assertEquals(library.getCurrentSize(), 50);
        Assert.assertTrue(library.getBooks().containsKey(book1));
        Assert.assertFalse(library.getBooks().containsKey(new Book("blah", "blah", 123)));
    }

    @Test
    public void getBookTest() {
        // given:
        Library library = new Library(100);
        Book book1 = new Book("King", "It", 400);

        // when:
        library.put(book1, 50);
        library.get(book1, 20);
        library.get(book1, 10);

        // then:
        Assert.assertEquals(library.getCurrentSize(), 20);
    }

    @Test
    public void capacityTest() {
        // given: вместимость 100 книг
        Library library = new Library(100);
        Book book1 = new Book("King", "It", 400);

        // when: добавляем 50 книг
        library.put(book1, 50);
        Assert.assertTrue(library.hasSpace());

        // when: добавляем еще 50 книг
        library.put(book1, 50);

        // then: заполнили библиотеку
        Assert.assertTrue(library.isFull());

        // when: достаем несколько книг
        library.get(book1, 20);

        // then: проверяем, что освободились места
        Assert.assertTrue(library.hasSpace());
    }
}
