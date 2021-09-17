package com.joanna.springBoot1.api;

import com.joanna.springBoot1.model.Book;
import com.joanna.springBoot1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService personService) {
        this.bookService = personService;
    }

//    @PostMapping
//    public void addBook(int index, String author, String title) {
//        bookService.addBook(index, author, title);
//    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
