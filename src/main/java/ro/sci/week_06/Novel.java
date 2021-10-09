package ro.sci.week_06;

public class Novel extends Book {
    public String novelType;

    public Novel(String bookName, String authorName, int numberOfPages, String novelType) {
        super(bookName, authorName, numberOfPages);
        this.novelType = novelType;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", novelType='" + novelType + '\'' +
                '}';
    }
}
