import java.util.Comparator;

public class BookByAuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.Author.compareTo(book2.Author);
    }
}
