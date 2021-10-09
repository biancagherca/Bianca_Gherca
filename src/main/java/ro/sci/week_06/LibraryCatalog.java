package ro.sci.week_06;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
        System.out.println("You added " + book);

    }

    public void deleteBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        }
        System.out.println("You removed " + book);
    }

    public void listBook() {
        System.out.println("The library catalogue contains this books: ");
        books.forEach(System.out::println);

    }
}
