package mk.ukim.finki.vb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bookstore {
    private Long id;
    private String name;
    private String city;
    private String address;
    private List<Book> books;

    public Bookstore(Long id, String name, String city, String address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        books=new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
