package homework4.library;

/**
 * @author Egor Stepanov
 * @since 19/10/2017.
 */
public class Book {

    private final String author;
    private final String title;
    private final int pages;

    Book(String author, String title, int pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
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

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
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
