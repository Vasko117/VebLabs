package mk.ukim.finki.vb.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private int score;

    private String description;

    @ManyToOne
    private Book book;

    @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss")
    private LocalDateTime timestamp;

}
