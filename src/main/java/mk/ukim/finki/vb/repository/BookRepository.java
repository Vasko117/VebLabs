package mk.ukim.finki.vb.repository;

import mk.ukim.finki.vb.bootstrap.DataHolder;
import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.model.Bookstore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository  {
//    public List<Book> findall(){
//        return DataHolder.books;
//    }
//    public Optional<Book> findByIsbn(String isbn){
//        return DataHolder.books.stream().filter(r->r.getIsbn().equals(isbn)).findFirst();
//    }
//    public Book save(String isbn,String title, String genre, int year, Long id){
//        DataHolder.books.removeIf(a->a.getIsbn().equals(isbn));
//        Optional<Bookstore> b1=DataHolder.bookstores.stream().filter(r->r.getId().equals(id)).findFirst();
//        if(b1.isPresent())
//        {
//            Bookstore b2=b1.get();
//            Book buk=new Book(title,genre,year,b2);
//            DataHolder.books.add(buk);
//            return buk;
//        }
//        return null;
//    }
//    public void createcopy(Book book)
//    {
//        if(DataHolder.books.stream().anyMatch(a->a.getIsbn().equals(book.getIsbn()))){
//            String title=book.getTitle();
//            String genre=book.getGenre();
//            Long isb=book.getIsbn();
//            Bookstore b=book.getBookstore();
//            int year=book.getYear();
//            List<Author> authors=book.getAuthors();
//            Book newbook=new Book(title,genre,year,b);
//            newbook.setAuthors(authors);
//            newbook.setTitle("Copy of "+ book.getTitle());
//            newbook.setIsbn(book.getIsbn()+"c");
//            DataHolder.books.add(newbook);
//        }
//    }
//   public void addAuthorToBook(Author author, Book book)
//   {
//       book.getAuthors().removeIf(a->a.getId().equals(author.getId()));
//       author.getBooks().removeIf(a->a.getIsbn().equals(book.getIsbn()));
//       book.getAuthors().add(author);
//       author.getBooks().add(book);
//   }
//    public void removeBook(String isbn)
//    {
//        if(findByIsbn(isbn).isPresent()){
//            Book book=findByIsbn(isbn).get();
//            DataHolder.books.remove(book);
//        }
//    }
}
