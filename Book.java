import java.util.Random;
public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;
    private static Random rand = new Random();

    // generates a random ISBN automatically
    private static String generateIsbn() {
    StringBuilder isbn = new StringBuilder();
    for (int i = 0; i < 13; i++) {
        isbn.append(rand.nextInt(10)); // adds one random digit at a time
    }
    return isbn.toString();
}
    // when author is not known - isbn auto generated
    public Book(String title) {
        this.isbn = generateIsbn();
        this.title = title;
        this.author = "Unknown";
        this.available = true;
    }
    // full details - isbn auto generated
    public Book(String title, String author) {
        this.isbn = generateIsbn();
        this.title = title;
        this.author = author;
        this.available = true;
    }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    public String setAvailable(boolean available) {
        this.available = available;
        return available ? "\"" + title + "\" is now available." : "\"" + title + "\" is now on loan.";
    }
    @Override
    public String toString() {
        String status = available ? "Available" : "Not Available";
        return  isbn + " _ " + title + " by " + author + " [" + status + "]";
    }
}