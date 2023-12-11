package mk.ukim.finki.vb.repository.jpa;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Bookstore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreJpaRepository extends JpaRepository<Bookstore,Long> {

}
