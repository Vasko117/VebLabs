package mk.ukim.finki.vb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Book {
    private String isbn;
    private String title;
    private String genre;
    private int year;
    private List<Author> authors;
    private Bookstore bookstore;

    public Book(String isbn, String title, String genre, int year, Bookstore bookstore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = new ArrayList<>();
        this.bookstore=bookstore;
    }

    public Bookstore getBookstore() {
        return bookstore;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
