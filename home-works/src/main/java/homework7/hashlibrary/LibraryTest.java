package homework7.hashlibrary;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Egor Stepanov
 * @since 27-10-2017.
 */
public class LibraryTest {

    @Test
    public void libraryTest() {

        LibraryHashChaining hashLibrary = new LibraryHashChaining(2, 100);

        Book book1 = new Book("King", "Blah", 500);
        Book book2 = new Book("Martin", "GoT", 2500);
        Book book3 = new Book("Vern", "20000", 200);

        hashLibrary.addBooks(book1, 20);
        hashLibrary.addBooks(book2, 40);
        hashLibrary.addBooks(book3, 40);
        Assert.assertEquals(hashLibrary.getSize(), 20+40+40);
        Assert.assertTrue(hashLibrary.isFull());

        hashLibrary.getBooks(book1, 15);
        Assert.assertEquals(hashLibrary.getSize(), 20+40+40-15);
        Assert.assertFalse(hashLibrary.isFull());

        Assert.assertEquals(hashLibrary.getBooks(new Book("some", "other", 200), 10), 0);
    }
}
