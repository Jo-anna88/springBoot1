package com.joanna.springBoot1.dao;

import com.joanna.springBoot1.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public int insertBook(Book book) {
        books.add(new Book(book.getIndex(), book.getAuthor(), book.getTitle())); //wykorzystujemy getter'y z konstruktora (te metody będą pobierać atrybuty z JSON properties)
        return 1; //here it means that insertion works (the item was added)
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Optional<Book> selectBookByIndex(int index) {
        return books.stream()
                //.filter(book -> book.getIndex().equals(index))
                .findFirst();
    }

    @Override
    public int deleteBookByIndex(int index) {
        Optional<Book> book = selectBookByIndex(index);
        if (book.isEmpty()) return 0;
        books.remove(book.get());
        return 1;
    }

    @Override
    public int updateBookByIndex(int index, Book book) {
        return 1;//selectBookByIndex(index);
    }

}
