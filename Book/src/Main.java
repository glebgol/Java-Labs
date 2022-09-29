import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Java", "Horstmann"));
        books.add(new Book("Разочарованный цветок", "Bob Mirskiy"));
        books.add(new Book("Евгений Онегин", "Пушкин"));
        books.add(new Book("Мертвые души", "Гоголь"));

        books.sort(new BookByAuthorComparator());
        System.out.println("Книги, отсортированные по автору:");
        for (var book : books) {
            System.out.println(book);
        }

        System.out.println();

        Collections.sort(books);
        System.out.println("Книги, отсортированные по названию:");
        for (var book : books) {
            System.out.println(book);
        }
    }
}