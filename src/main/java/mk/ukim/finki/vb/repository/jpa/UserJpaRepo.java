package mk.ukim.finki.vb.repository.jpa;

import mk.ukim.finki.vb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo extends JpaRepository<User,Long> {
}
