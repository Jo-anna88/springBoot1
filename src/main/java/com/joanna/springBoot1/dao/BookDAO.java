package com.joanna.springBoot1.dao;

import com.joanna.springBoot1.model.Book;

import java.util.List;

public interface BookDAO {
    //insert an object to our DB
    int insertBook(int index, String author, String title);
    List<Book> getAllBooks();

    //we can use UUID uuid = UUID.randomUUID(); (create UUID ver4) when we use UUID id against int index
}
