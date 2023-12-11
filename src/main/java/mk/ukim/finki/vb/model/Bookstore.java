package mk.ukim.finki.vb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Bookstore {
    @Id
    @Column(name = "bookstore_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookstore_name")
    private String name;

    private String city;

    private String address;

    @OneToMany(mappedBy = "bookstore", fetch = FetchType.EAGER)
    private List<Book> books;


}
