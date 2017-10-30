package module1.library;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Egor Stepanov
 * @since  27-10-2017.
 */
@RunWith(Parameterized.class)
public class LibraryTest {

    private Library hashLibrary;

    public LibraryTest(Library library) {
        this.hashLibrary = library;
    }

    @Test
    public void hashLibraryTest() {
        Book book1 = new Book("King", "Blah", 500);
        Book book2 = new Book("Martin", "GoT", 2500);
        Book book3 = new Book("Vern", "20000", 200);

        hashLibrary.addBooks(book1, 20);
        hashLibrary.addBooks(book2, 40);
        hashLibrary.addBooks(book3, 40);
        Assert.assertEquals(20+40+40, hashLibrary.getSize());
        Assert.assertTrue(hashLibrary.isFull());

        hashLibrary.getBooks(book1, 15);
        Assert.assertEquals(20+40+40-15, hashLibrary.getSize());
        Assert.assertFalse(hashLibrary.isFull());

        Assert.assertEquals(0, hashLibrary.getBooks(new Book("some", "other", 200), 10));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new LibraryHashChaining(10, 100)},
                new Object[]{new LibraryHashProbing(10, 100)}
        );
    }
}
