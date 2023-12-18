package mk.ukim.finki.vb.service;

import mk.ukim.finki.vb.model.User;

import java.util.List;

public interface AuthService {
    User login(String username, String password,String name, String surrname);

    List<User> findAll();
}
