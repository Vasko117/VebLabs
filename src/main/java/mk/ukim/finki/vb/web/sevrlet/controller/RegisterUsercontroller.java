package mk.ukim.finki.vb.web.sevrlet.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.vb.model.User;
import mk.ukim.finki.vb.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterUsercontroller {
    private final AuthService authService;

    public RegisterUsercontroller(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getRegisterPage() {

        return "login";
    }

    @PostMapping
    public String register(HttpServletRequest request, Model model, @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String name,
                           @RequestParam String surname) {
        User user=this.authService.login(username, password, name, surname);
        request.getSession().setAttribute("user", user);
        return "redirect:/books";
    }

}
