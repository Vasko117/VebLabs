package mk.ukim.finki.vb.web.sevrlet.controller;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.service.AuthorService;
import mk.ukim.finki.vb.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Controller
@RequestMapping("/authordetail")
public class authorDetails {
    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorService authorService;
    private final BookService bookService;

    public authorDetails(SpringTemplateEngine springTemplateEngine, AuthorService authorService,BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
        this.bookService=bookService;
    }
    @GetMapping
    public String getBooksPage(@RequestParam String authorID, Model model){
        Author author=authorService.findById(Long.parseLong(authorID));
        model.addAttribute("deauthor",author);
        return "authoDetails";
    }
}
