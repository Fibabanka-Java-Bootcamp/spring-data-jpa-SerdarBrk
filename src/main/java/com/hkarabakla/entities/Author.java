package com.hkarabakla.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name="author_book",
                joinColumns = @JoinColumn(name = "author_id"),
                inverseJoinColumns = @JoinColumn(name="book_isbn"))
    private List<Book> books;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<Book> getBooks() {return books;}
    public void setBooks(List<Book> books) {this.books = books;}
}