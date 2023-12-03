package mk.ukim.finki.vb.service;

import mk.ukim.finki.vb.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> listAuthors();
    Author findById(Long id);
}
