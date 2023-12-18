package mk.ukim.finki.vb.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.vb.model.Book;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "shop_users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;

    private String password;

    private String name;

    private String surrname;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> wishlist;

    public User(){}

    public User(String username, String password, String name, String surrname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surrname = surrname;
        this.wishlist=new ArrayList<>();
    }
}

