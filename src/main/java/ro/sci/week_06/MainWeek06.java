package ro.sci.week_06;

public class MainWeek06 {
    public static void main(String[] args) {


        Book book1 = new Novel("Gone Girl", "Gillian Flynn", 432, "Mystery");
        Book book2 = new Novel("The Silent Patient ", "Alex Michaelides", 336, "Mystery");
        Book book3 = new Novel("The Lord Of The Rings ", "J.R.R. Tolkien", 450, "Science-Fiction");
        Book book4 = new ArtAlbum("Album Art ", "JOHN FOSTER", 336, "Paperback ");
        Book book5 = new ArtAlbum("The History of Graphic Design ", "JENS MULLER", 480, "Hardcover ");

        LibraryCatalog libraryCatalog=new LibraryCatalog();
        libraryCatalog.addBook(book1);
        libraryCatalog.addBook(book2);
        libraryCatalog.addBook(book3);
        libraryCatalog.addBook(book4);
        libraryCatalog.addBook(book5);

        libraryCatalog.deleteBook(book3);
        libraryCatalog.deleteBook(book2);

        libraryCatalog.addBook(book2);

        libraryCatalog.listBook();


    }
}
