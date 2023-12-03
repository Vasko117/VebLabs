package mk.ukim.finki.vb.service;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();
    void addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
    void deleteBook(String isbn);
    void saveBook(String isbn, String title, String genre, int year, Long id);
    void copy(Book book);
}
