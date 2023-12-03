package mk.ukim.finki.vb.web.sevrlet.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.service.AuthorService;
import mk.ukim.finki.vb.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(SpringTemplateEngine springTemplateEngine, AuthorService authorService, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
        this.bookService = bookService;
    }
    @GetMapping
    public String getAuthorPage(HttpServletRequest req, Model model) {
        Book book = bookService.findBookByIsbn(req.getParameter("bookISBN"));
        model.addAttribute("authorss", this.authorService.listAuthors());
        model.addAttribute("debuk", book);
        return "authorList";
    }
    @PostMapping("/getDetails/{bookISBN}")
    public String gotoAuthors(@RequestParam String authorID, @PathVariable String bookISBN) {
        Long iid=Long.parseLong(authorID);
        bookService.addAuthorToBook(iid,bookISBN);
        return "redirect:/bookdetail?bookISBN=" + bookISBN;
    }
}
