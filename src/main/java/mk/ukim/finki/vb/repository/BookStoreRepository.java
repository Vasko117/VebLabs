package mk.ukim.finki.vb.repository;

import mk.ukim.finki.vb.bootstrap.DataHolder;
import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.model.Bookstore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookStoreRepository {
    public List<Bookstore> findall(){
        return DataHolder.bookstores;
    }
    public Optional<Bookstore> findById(Long id){
        return DataHolder.bookstores.stream().filter(r->r.getId().equals(id)).findFirst();
    }

}
