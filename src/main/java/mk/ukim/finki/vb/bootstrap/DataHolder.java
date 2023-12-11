package mk.ukim.finki.vb.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.AuthorFullName;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.model.Bookstore;
import mk.ukim.finki.vb.repository.jpa.AuthJpaRepository;
import mk.ukim.finki.vb.repository.jpa.BookJpaRepository;
import mk.ukim.finki.vb.repository.jpa.BookStoreJpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    private final AuthJpaRepository authJpaRepository;
    private final BookStoreJpaRepository bookStoreJpaRepository;
    private final BookJpaRepository bookJpaRepository;

    public static List<Author> authors=new ArrayList<>();
    public static List<Book> books=new ArrayList<>();
    public static List<Bookstore> bookstores=new ArrayList<>();

    public DataHolder(AuthJpaRepository authJpaRepository, BookStoreJpaRepository bookStoreJpaRepository, BookJpaRepository bookJpaRepository) {
        this.authJpaRepository = authJpaRepository;
        this.bookStoreJpaRepository = bookStoreJpaRepository;
        this.bookJpaRepository = bookJpaRepository;
    }

    @PostConstruct
    public void init() {
        if(authors.size()==0)
        {
            authors.add(Author.builder().fullname(AuthorFullName.builder().name("William").surname("Shakespeare").build()).biography("Smart").build());
            authors.add(Author.builder().fullname(AuthorFullName.builder().name("Agatha").surname("Cristie").build()).biography("Smart").build());
            authors.add(Author.builder().fullname(AuthorFullName.builder().name("Barbara").surname("Cartland").build()).biography("Smart").build());
            authors.add(Author.builder().fullname(AuthorFullName.builder().name("Harold").surname("Robbins").build()).biography("Smart").build());
            authors.add(Author.builder().fullname(AuthorFullName.builder().name("Enid").surname("Blyton").build()).biography("Smart").build());
            authJpaRepository.saveAll(authors);
        }
        if(books.size()==0)
        {
            Bookstore bookstore1=Bookstore.builder().name("Akademska kniga").city("Skopje").address("Centar").build();
            Bookstore bookstore2=Bookstore.builder().name("Knizara").city("Skopje").address("aerodrom").build();
            Bookstore bookstore3=Bookstore.builder().name("Albatros").city("Skopje").address("Gazi baba").build();
            Bookstore bookstore4=Bookstore.builder().name("Biblioteka").city("Skopje").address("aerodrom").build();
            Bookstore bookstore5=Bookstore.builder().name("Angliski centar").city("Skopje").address("Centar").build();
            books.add(Book.builder().title("THE SECRET").genre("tragedy").year(2013).bookstore(bookstore1).build());
            books.add(Book.builder().title("THE EXCHANGE").genre("comedy").year(2012).bookstore(bookstore2).build());
            books.add(Book.builder().title("KING OF GREED").genre("romance").year(2011).bookstore(bookstore3).build());
            books.add(Book.builder().title("FOURTH WING").genre("comedy").year(2010).bookstore(bookstore4).build());
            books.add(Book.builder().title("LESSONS IN CHEMISTRY").genre("horror").year(2009).bookstore(bookstore5).build());
            bookstores.add(bookstore1);
            bookstores.add(bookstore2);
            bookstores.add(bookstore3);
            bookstores.add(bookstore4);
            bookstores.add(bookstore5);
            bookStoreJpaRepository.saveAll(bookstores);
            bookJpaRepository.saveAll(books);

        }
    }
}