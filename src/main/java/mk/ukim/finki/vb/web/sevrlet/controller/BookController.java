package mk.ukim.finki.vb.web.sevrlet.controller;

import mk.ukim.finki.vb.model.Book;
import mk.ukim.finki.vb.service.BookStoreService;
import org.springframework.ui.Model;
import mk.ukim.finki.vb.service.AuthorService;
import mk.ukim.finki.vb.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/books")
public class BookController {
    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BookStoreService bookStoreService;
    public BookController(SpringTemplateEngine springTemplateEngine, AuthorService authorService, BookService bookService, BookStoreService bookStoreService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("books",this.bookService.listBooks());
        return "listBooks";
    }
    @GetMapping("/delete/{isbn}")
    public String deleteProduct(@PathVariable String isbn) {
        this.bookService.deleteBook(isbn);
        return "redirect:/books";
    }
    @GetMapping("/edit-form/{isbn}")
    public String editProductPage(@PathVariable String isbn, Model model) {
        Book book=bookService.findBookByIsbn(isbn);
        if (book!=null) {
            model.addAttribute("bookstores", this.bookStoreService.findAll());
            model.addAttribute("debuk", book);
            return "add-book";
        }
        return "redirect:/books?error=ProductNotFound";
    }
    @GetMapping("/copy-form/{isbn}")
    public String copyProductPage(@PathVariable String isbn, Model model) {
        Book book=bookService.findBookByIsbn(isbn);
        bookService.copy(book);
        return "redirect:/books";
    }
    @GetMapping("/review-form/{isbn}")
    public String reviewProductPage(@PathVariable String isbn, Model model) {
        Book book=bookService.findBookByIsbn(isbn);
        model.addAttribute("debuk", book);
        return "review-add";
    }
    @GetMapping("/add-form")
    public String addBookPage( Model model) {
        model.addAttribute("bookstores", this.bookStoreService.findAll());
        return "add-book";
    }
    @GetMapping("/review-view/{isbn}")
    public String reviewview(@PathVariable String isbn, Model model) {
        Book book=this.bookService.findBookByIsbn(isbn);
        model.addAttribute("debuk", book);
        return "view-rev";
    }
    @PostMapping("/add")
    public String saveProduct(@RequestParam String isbn,
                              @RequestParam String title,
                              @RequestParam String genre,
                              @RequestParam Integer year,
                              @RequestParam Long bookstoreId) {
        this.bookService.saveBook(isbn, title, genre, year, bookstoreId);
        return "redirect:/books";
    }
    @PostMapping("/add-rev{isbn}")
    public String addreview(@PathVariable String isbn,@RequestParam Integer score,
                              @RequestParam String description,
                              @RequestParam LocalDateTime date) {
        this.bookService.addReview(isbn,score,description,date);
        return "redirect:/books";
    }
    @PostMapping("/getAuthors")
    public String gotoAuthors(@RequestParam String bookISBN, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("bookISBN", bookISBN);
        return "redirect:/author";
    }
}
