package mk.ukim.finki.vb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Author {
     Long id;
     String name;
    String surname;
    String biography;
    List<Book> books;


    public Author(Long id,String name, String surname) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.books = new ArrayList<>();
    }

    public Author(Long id, String name, String surname, String biography) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
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

    public String getSurname() {
        return surname;
    }

    public String getBiography() {
        return biography;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
