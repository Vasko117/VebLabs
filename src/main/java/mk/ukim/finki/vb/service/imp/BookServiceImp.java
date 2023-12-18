package mk.ukim.finki.vb.service.imp;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.model.Bookstore;
import mk.ukim.finki.vb.model.Review;
import mk.ukim.finki.vb.repository.jpa.AuthJpaRepository;
import mk.ukim.finki.vb.repository.jpa.BookJpaRepository;
import mk.ukim.finki.vb.repository.jpa.BookStoreJpaRepository;
import mk.ukim.finki.vb.repository.jpa.ReviewJpaRepository;
import mk.ukim.finki.vb.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService {
    private final BookJpaRepository booksrepo;
    private final AuthJpaRepository authrepo;
    private final BookStoreJpaRepository bookStoreRepository;
    private final ReviewJpaRepository reviewJpaRepository;

    public BookServiceImp(BookJpaRepository booksrepo, AuthJpaRepository authrepo, BookStoreJpaRepository bookStoreRepository, ReviewJpaRepository reviewJpaRepository) {
        this.booksrepo = booksrepo;
        this.authrepo = authrepo;
        this.bookStoreRepository = bookStoreRepository;
        this.reviewJpaRepository = reviewJpaRepository;
    }

    @Override
    public List<Book> listBooks(){
        return booksrepo.findAll();
    }
    @Override
    public void addAuthorToBook(Long authorId, String isbn){
        Optional<Author> authorot=authrepo.findById(authorId);
        Optional<Book> knigata=booksrepo.findById(isbn);
        Book debuk;
        Author deuthor;
        if(knigata.isPresent() && authorot.isPresent())
        {
            deuthor=authorot.get();
            debuk=knigata.get();

            debuk.getAuthors().add(deuthor);
            this.booksrepo.save(debuk);
            deuthor.getBooks().add(debuk);
            this.authrepo.save(deuthor);
        }

    }
    @Override
    public Book findBookByIsbn(String isbn){
        Optional<Book> knigata=booksrepo.findById(isbn);
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
        this.booksrepo.deleteById(isbn);
    }
    @Override
    public void saveBook(String isbn,String title, String genre, int year,Long id)
    {
        Optional<Bookstore> b=this.bookStoreRepository.findById(id);
        b.ifPresent(bookstore -> this.booksrepo.save(Book.builder().title(title).genre(genre).year(year).bookstore(bookstore).build()));

    }
    @Override
    public void copy(Book book){
        this.booksrepo.save(Book.builder().title("Copy of " + book.getTitle()).genre(book.getGenre()).year(book.getYear()).bookstore(book.getBookstore()).build());
    }

    @Override
    public void addReview(String isbn, int score, String description, LocalDateTime date) {
        Optional<Book> b=this.booksrepo.findById(isbn);
        if(b.isPresent())
        {
            Review r= Review.builder().score(score).description(description).book(b.get()).timestamp(date).build();
            this.reviewJpaRepository.save(r);
            b.get().getReviews().add(r);
            this.booksrepo.save(b.get());
        }

    }

    @Override
    public void filterreview(LocalDateTime from, LocalDateTime to,Book book) {
        List<Review> filteredReviews = book.getReviews().stream()
                .filter(review -> review.getTimestamp().isAfter(from) && review.getTimestamp().isBefore(to))
                .collect(Collectors.toList());

        // Update the book's list of reviews with the filtered list
        book.setReviews(filteredReviews);

        // Save the book to persist the changes
        this.booksrepo.save(book);
    }

    @Override
    public void save(Book book) {
        this.booksrepo.save(book);
    }

}
