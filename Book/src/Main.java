import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var books = new BookList();
        books.Add(new Book("Java", "Horstmann"));
        books.Add(new Book("Разочарованный цветок", "Bob Mirskiy"));
        books.Add(new Book("Евгений Онегин", "Пушкин"));
        books.Add(new Book("Мертвые души", "Гоголь"));
        books.Add(new Book("Капитанская дочка", "Пушкин"));

        books.PrintBooks();
        var s = books.FilterByAuthorName("Пушкин");
        System.out.println();
        s.PrintBooks();

        var res = books.GroupByAuthorName("Пушкин");
        System.out.println(res);
    }
}