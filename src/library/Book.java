package library;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a book in the library.
 */
public class Book {
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private String ISBN;
    private List<BookCopy> copies;

    /**
     * Constructs a new Book.
     *
     * @param title     the title of the book
     * @param author    the author of the book
     * @param genre     the genre of the book
     * @param publisher the publisher of the book
     * @param ISBN      the ISBN of the book
     */
    public Book(String title, String author, String genre, String publisher, String ISBN) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.copies = new ArrayList<>();
        addCopy(new BookCopy(this));
    }

    /**
     * Adds a copy of the book.
     *
     * @param bookCopy the copy to add
     * @return true if the copy was added successfully, false otherwise
     */
    public boolean addCopy(BookCopy bookCopy) {
        return copies.add(bookCopy);
    }

    /**
     * Removes a copy of the book by its ID.
     *
     * @param id the ID of the copy to remove
     * @return true if the copy was removed successfully, false otherwise
     */
    public boolean removeCopy(int id) {
        return copies.removeIf(bookCopy -> bookCopy.getId() == id);
    }

    // Getters and setters

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

    public List<BookCopy> getCopies() {
        return copies;
    }

    public void setCopies(List<BookCopy> copies) {
        this.copies = copies;
    }
}
