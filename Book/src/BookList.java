import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BookList implements Iterable<Book>{
    private ArrayList<Book> Books;
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
        return Collections.binarySearch(Books, new Book(name, null), Book::compareTo);
    }
    public void Add(Book b) {
        Books.add(b);
    }
    public BookList FindBooksByAuthor(String authorName) {
        BookList booksByAuthor = new BookList();
        for (var book : Books) {
            if (book.Author.equals(authorName)) {
                booksByAuthor.Add(book);
            }
        }
        return booksByAuthor;
    }

    public Book Get(int index) {
        return Books.get(index);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookListIterator();
    }
    class BookListIterator implements Iterator<Book> {
        Book nextBook;
        int currentIndex;
        public BookListIterator() {
            nextBook = Books.get(0);
            currentIndex = 0;
        }
        @Override
        public boolean hasNext() {
            return currentIndex < Books.size();
        }

        @Override
        public Book next() {
            Book result = nextBook;
            if (++currentIndex < Books.size()) {
                nextBook = Books.get(currentIndex);
            }
            return result;
        }
    }
}
