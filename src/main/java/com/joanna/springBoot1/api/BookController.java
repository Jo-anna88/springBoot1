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

    //e.g. POST -> raw JSON file
    //    {
    //        "index": 333,
    //        "author": "Michaił Bułhakow",
    //        "title": "Mistrz i Małgorzata"
    //    }
    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    //http://localhost:8080/books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //e.g. http://localhost:8080/books/333, where '333' is the index of a book to GET info
    @GetMapping(path = "{index}")
    public Book getBookByIndex(@PathVariable("index") int index) {
        return bookService.getBookByIndex(index)
                .orElse(null); //e.g. 404 or msg or ...
    }

    //e.g. http://localhost:8080/books/123, where '123' is the index of a book to DELETE
    @DeleteMapping(path = "{index}")
    public void deleteBookByIndex(@PathVariable("index") int index) {
        bookService.deleteBookByIndex(index);
    }

    //e.g. http://localhost:8080/books/234, where '234' is the index of a book to update (PUT)
    @PutMapping(path = "{index}")
    public void updateBookByIndex(@PathVariable("index") int index, @RequestBody Book book) {
        bookService.updateBookByIndex(index,book);
    }
}
