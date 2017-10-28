package module1.library;

/**
 * @author Egor Stepanov
 * @since  27/10/2017.
 */
public class Book {

    private final String author;
    private final String title;
    private final int pages;

    private int quantity;

    Book(String author, String title, int pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    Book(Book book, int quantity) {
        this.author = book.author;
        this.title = book.title;
        this.pages = book.pages;
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return (author != null ? author.equals(book.author) : book.author == null) &&
                (title != null ? title.equals(book.title) : book.title == null) &&
                pages == book.pages;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + pages;
        return result;
    }
}
