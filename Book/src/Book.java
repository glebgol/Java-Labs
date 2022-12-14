import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Comparator;

public class Book implements Comparable<Book>{
    public String Name;
    public String Author;

    public Book(String name, String author) {
        Name = name;
        Author = author;
    }
    @Override
    public int compareTo(Book book) {
        return Name.compareTo(book.Name);
    }
    @Override
    public String toString() {
        return Name;
    }
    static class BookByAuthorComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.Author.compareTo(book2.Author);
        }
    }
    public String toJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(this);
    }
}
