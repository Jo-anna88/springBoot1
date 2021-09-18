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

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{index}")
    public Book getBookByIndex(@PathVariable("index") int index) {
        return bookService.getBookByIndex(index)
                .orElse(null); //e.g. 404 or msg or ...
    }

    @DeleteMapping(path = "{index}")
    public void deleteBookByIndex(@PathVariable("index") int index) {
        bookService.deleteBookByIndex(index);
    }

    @PutMapping(path = "{index}")
    public void updateBookByIndex(@PathVariable("index") int index, @RequestBody Book book) {
        bookService.updateBookByIndex(index,book);
    }
}
