package mk.ukim.finki.vb.service.imp;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.repository.AuthorRepository;
import mk.ukim.finki.vb.repository.BookRepository;
import mk.ukim.finki.vb.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {
    private final BookRepository booksrepo;
    private final AuthorRepository authrepo;

    public BookServiceImp(BookRepository booksrepo, AuthorRepository authrepo) {
        this.booksrepo = booksrepo;
        this.authrepo = authrepo;
    }

    @Override
    public List<Book> listBooks(){
        return booksrepo.findall();
    }
    @Override
    public void addAuthorToBook(Long authorId, String isbn){
        Optional<Author> authorot=authrepo.findById(authorId);
        Optional<Book> knigata=booksrepo.findByIsbn(isbn);
        Book debuk;
        Author deuthor;
        if(knigata.isPresent() && authorot.isPresent())
        {
            deuthor=authorot.get();
            debuk=knigata.get();
            booksrepo.addAuthorToBook(deuthor,debuk);
        }

    }
    @Override
    public Book findBookByIsbn(String isbn){
        Optional<Book> knigata=booksrepo.findByIsbn(isbn);
        Book debuk;
        if(knigata.isPresent())
        {
            debuk=knigata.get();
           return debuk;
        }
        else {
            return null;
        }
    }
    @Override
    public void deleteBook(String isbn)
    {
        this.booksrepo.removeBook(isbn);
    }
    @Override
    public void saveBook(String isbn,String title, String genre, int year,Long id)
    {
        this.booksrepo.save(isbn,title,genre,year,id);
    }
    @Override
    public void copy(Book book){
        this.booksrepo.createcopy(book);
    }
}
