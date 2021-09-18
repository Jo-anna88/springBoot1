package com.joanna.springBoot1.service;

import com.joanna.springBoot1.dao.BookDAO;
import com.joanna.springBoot1.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookDAO bookDAO;

    //we create a constructor, because bookDAO is 'final'
    @Autowired
    public BookService(@Qualifier("fakeDAO") BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public int addBook (Book book) {
        return bookDAO.insertBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public Optional<Book> getBookByIndex(int index) {
        return bookDAO.selectBookByIndex(index);
    }

    public int deleteBookByIndex(int index) {
        return bookDAO.deleteBookByIndex(index);
    }

    public int updateBookByIndex(int index, Book book) {
        return bookDAO.updateBookByIndex(index, book);
    }
}
