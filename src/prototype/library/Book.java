package prototype.library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private String ISBN;
    private List<BookCopy> copies;

    public Book(String title, String author, String genre, String publisher, String ISBN) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.copies = new ArrayList<>();
        addCopy(new BookCopy(this));
    }


    public void addCopy(BookCopy bookCopy) {
        copies.add(bookCopy);
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
