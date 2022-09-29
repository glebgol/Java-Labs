public class Book implements Comparable<Book>{
    public String Name;
    public String Author;

    @Override
    public int compareTo(Book book) {
        return Name.compareTo(book.Name);
    }
}
