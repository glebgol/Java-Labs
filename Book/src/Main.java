import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var books = new BookList();
        books.Add(new Book("Java", "Horstmann"));
        books.Add(new Book("Разочарованный цветок", "Bob Mirskiy"));
        books.Add(new Book("Евгений Онегин", "Пушкин"));
        books.Add(new Book("Мертвые души", "Гоголь"));
        books.Add(new Book("Капитанская дочка", "Пушкин"));

        var booksByAuthor = books.FindBooksByAuthor("Пушкин");
        System.out.println("Книги Пушкина:");
        for (var x:booksByAuthor) {
            System.out.println(x);
        }

        System.out.println();

        System.out.println("Книги, отсортированные по автору: ");

        books.SortByAuthor();
        for (var x:books) {
            System.out.println(x);
        }
        System.out.println(books.BinarySearchByName("Лермонтов"));
        var book = new Book("Книга", "Автор");
        System.out.println(book.toJson());

        System.out.println(books.toJson());
        books.WriteToJsonFile("books.json");

        var readedFromJsonFileBooks = new BookList();
        readedFromJsonFileBooks.ReadFromJsonFile("books.json");
        for (var x:readedFromJsonFileBooks) {
            System.out.println(x);
        }
    }
}