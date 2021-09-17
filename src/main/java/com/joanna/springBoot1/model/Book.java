package com.joanna.springBoot1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    int index; //or UUID id; //UUID-Universally Unique Identifier
    String author;
    String title;

    public Book(@JsonProperty("index") int index, @JsonProperty("author") String author, @JsonProperty("title") String title) {
        this.index = index;
        this.author = author;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
