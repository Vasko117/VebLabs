package mk.ukim.finki.vb.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.model.Bookstore;
import mk.ukim.finki.vb.model.Kategorija;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors=new ArrayList<>();
    public static List<Book> books=new ArrayList<>();
    public static List<Bookstore> bookstores=new ArrayList<>();

    @PostConstruct
    public void init() {
        authors.add(new Author((long)234243,"William","Shakespeare"));
        authors.add(new Author((long)453656,"Agatha","Cristie"));
        authors.add(new Author((long)346363,"Barbara","Cartland"));
        authors.add(new Author((long)56956,"Harold","Robbins"));
        authors.add(new Author((long)4545,"Enid","Blyton"));
        Bookstore bookstore1=new Bookstore((long)456546 ,"Akademska kniga","SKopje","Centar");
        Bookstore bookstore2=new Bookstore((long)76575 ,"Knizara","Skopje","Karpos");
        Bookstore bookstore3=new Bookstore((long)9897 ,"Biblioteka","Skopje","aerodrom");
        Bookstore bookstore4=new Bookstore((long)534535 ,"Albatros","Skopje","Gazi baba");
        Bookstore bookstore5=new Bookstore((long)575675 ,"Angliski centar","Skopje","Centar");
        books.add(new Book("978-1-60432-502-0","THE SECRET","tragedy",2013,bookstore1));
        books.add(new Book("978-1-60309-517-4","THE EXCHANGE","comedy",2012,bookstore2));
        books.add(new Book("978-1-60309-535-8","KING OF GREED","romance",2011,bookstore3));
        books.add(new Book("978-1-60309-492-4","FOURTH WING","comedy",2010,bookstore4));
        books.add(new Book("978-1-60309-513-6","LESSONS IN CHEMISTRY","horror",2009,bookstore5));
        bookstores.add(bookstore1);
        bookstores.add(bookstore2);
        bookstores.add(bookstore3);
        bookstores.add(bookstore4);
        bookstores.add(bookstore5);

    }
}
