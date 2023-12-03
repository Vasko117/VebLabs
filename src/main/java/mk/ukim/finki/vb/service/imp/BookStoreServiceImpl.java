package mk.ukim.finki.vb.service.imp;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Bookstore;
import mk.ukim.finki.vb.repository.BookStoreRepository;
import mk.ukim.finki.vb.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<Bookstore> findAll() {
        return bookStoreRepository.findall();
    }
    @Override
    public Bookstore findById(Long id){
        Optional<Bookstore> bookstore= bookStoreRepository.findById(id);
        Bookstore debukstore;
        if(bookstore.isPresent())
        {
            debukstore=bookstore.get();
            return debukstore;
        }
        else {
            return null;
        }
    }
}
