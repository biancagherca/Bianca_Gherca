package ro.sci.week_06;

public class ArtAlbum extends Book{
    public String paperQuality;

    public ArtAlbum(String bookName, String authorName, int numberOfPages, String paperQuality) {
        super(bookName, authorName, numberOfPages);
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return "ArtAlbum{" +

                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", paperQuality='" + paperQuality + '\'' +
                '}';
    }
}
