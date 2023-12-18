package mk.ukim.finki.vb.service.imp;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.model.User;
import mk.ukim.finki.vb.repository.jpa.UserJpaRepo;
import mk.ukim.finki.vb.service.AuthService;
import mk.ukim.finki.vb.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImp implements AuthService {
    private final UserJpaRepo userJpaRepo;

    public AuthServiceImp(UserJpaRepo userJpaRepo) {
        this.userJpaRepo = userJpaRepo;
    }


    @Override
    public User login(String username, String password, String name, String surname) {
        User user = new User(username, password, name, surname);
        return userJpaRepo.save(user);

    }

    @Override
    public List<User> findAll() {
        return userJpaRepo.findAll();
    }
}
