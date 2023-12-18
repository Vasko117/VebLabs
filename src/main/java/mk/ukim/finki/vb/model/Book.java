package mk.ukim.finki.vb.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "book_entity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "book_id")
    private String isbn;

    private String title;

    private String genre;

    boolean isinwishlist=false;

    private int year;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @ManyToOne
    private Bookstore bookstore;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private List<Review> reviews;


}
