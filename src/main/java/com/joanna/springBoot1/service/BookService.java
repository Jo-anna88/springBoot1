package com.joanna.springBoot1.service;

import com.joanna.springBoot1.dao.BookDAO;
import com.joanna.springBoot1.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDAO bookDAO;

    //we create a constructor, because bookDAO is 'final'
    @Autowired
    public BookService(@Qualifier("fakeDAO") BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public int addBook (int index, String author, String title) {
        return bookDAO.insertBook(index,author,title);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
}
