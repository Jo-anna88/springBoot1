package com.joanna.springBoot1.dao;

import com.joanna.springBoot1.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    //insert an object to our DB
    int insertBook(Book book);

    //return all books from our 'database'
    List<Book> getAllBooks();

    //select a book (if exist in our DB) --> Optional<T>
    Optional<Book> selectBookByIndex(int index);

    //remove a book from our 'database'
    int deleteBookByIndex(int index);

    //update info about a book
    int updateBookByIndex(int index, Book book);

    //we can use UUID uuid = UUID.randomUUID(); (create UUID ver4) when we use UUID id against int index (creating by server)
}
