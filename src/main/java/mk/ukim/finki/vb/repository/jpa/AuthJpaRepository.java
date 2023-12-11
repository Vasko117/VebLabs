package mk.ukim.finki.vb.repository.jpa;

import mk.ukim.finki.vb.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthJpaRepository extends JpaRepository<Author,Long> {

}
