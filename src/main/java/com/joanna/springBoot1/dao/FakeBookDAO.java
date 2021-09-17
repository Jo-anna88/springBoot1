package com.joanna.springBoot1.dao;

import com.joanna.springBoot1.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeDAO")
public class FakeBookDAO implements BookDAO {
    private static List<Book> books = new ArrayList<>(); //books - our database
    static {
        {
            books.add(new Book(123,"Stephen King", "The Dark Tower"));
            books.add(new Book(234, "Maria Miduch", "Oddech Boga"));
        }
    }
    @Override
    public int insertBook(int index, String author, String title) {
        books.add(new Book(index,author,title));
        return 1; //here it means that insertion works (the item was added)
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}
