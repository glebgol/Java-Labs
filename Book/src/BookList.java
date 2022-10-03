import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BookList {
    public ArrayList<Book> Books;
    public BookList() {
        Books = new ArrayList<>();
    }
    public void SortByAuthor() {
        Collections.sort(Books, new Book.BookByAuthorComparator());
    }
    public void SortByName() {
        Collections.sort(Books);
    }
    public int BinarySearchByName(String name) {
        int index = Collections.binarySearch(Books, new Book(name, null), Book::compareTo);
        return index;
    }
    public void Add(Book b) {
        Books.add(b);
    }
    public ArrayList<Book> FindBooksByAuthor(String authorName) {
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        for (var book : Books) {
            if (book.Author.equals(authorName)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
}
