import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BookList implements Iterable<Book>, Cloneable{
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

    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    public void WriteToJsonFile(String jsonFileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = Files.newBufferedWriter(Paths.get(jsonFileName));
        gson.toJson(this, writer);
        writer.close();
    }

    public void ReadFromJsonFile(String jsonFileName) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(jsonFileName));
        var bookList = (gson.fromJson(reader, BookList.class));
        //Boo
        reader.close();
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
