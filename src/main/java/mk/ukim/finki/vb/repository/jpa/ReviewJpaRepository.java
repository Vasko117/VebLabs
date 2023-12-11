package mk.ukim.finki.vb.repository.jpa;


import mk.ukim.finki.vb.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewJpaRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByTimestampBetween(LocalDateTime after, LocalDateTime before);
}
