package mk.ukim.finki.vb.service;
import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Bookstore;
import java.util.List;

public interface BookStoreService {
     List<Bookstore> findAll();
     Bookstore findById(Long id);
}
