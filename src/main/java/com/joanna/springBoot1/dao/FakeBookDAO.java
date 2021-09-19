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
            books.add(new Book(234, "George Orwell", "1984"));
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
                .filter(book -> book.getIndex()==index)
                .findFirst();
        //'easier' way: - before Java8/11
        //books.get(index);
        //void (no return)
    }

    @Override
    public int deleteBookByIndex(int index) {
        Optional<Book> book = selectBookByIndex(index);
        if (book.isEmpty()) return 0; //Optional.isEmpty() - If a value is not present, returns true, otherwise false
        books.remove(book.get()); //Optional.get() - If a value is present in this Optional, returns the value (otherwise throws NoSuchElementException)
        return 1;
        //'easier' way:
        //books.remove(index);
        //void (no return)
    }

    @Override
    public int updateBookByIndex(int index, Book updatedBook) {
        return selectBookByIndex(index)
                .map(book -> { //zakładamy, że w Optional'u jest książka
                    int indexOfBook = books.indexOf(book); //wyszukanie indeksu ksiazki na liscie (w DB)
                    if (indexOfBook >= 0) { //jesli indeks istnieje...
                        books.set(indexOfBook, new Book(index,updatedBook.getAuthor(),updatedBook.getTitle())); //ustawienie nowych wartosci pod tym indeksem
                        return 1;
                    }
                    return 0; //jesli indeks nie istnieje...
                })
                .orElse(0); //Optional.orElse - If a value is present, returns the value, otherwise returns other (default value); here: other=0
    }
    //'easier' way:
    //Book book = books.get(updatedBook.getIndex());
    //book.setTitle(updatedBook.getTitle());
    //...
    //books.add(...);
}
