public class Main {
    public static void main(String[] args) {
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
    }
}