package mk.ukim.finki.vb.repository.jpa;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<Book,String> {
}
