package com.hkarabakla.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
public class Order {
    @Id
    @GeneratedValue
    private int id;

    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user_id;

    private double total;

    @ManyToMany
    @JoinTable(name="order_book",
                joinColumns = @JoinColumn(name="order_id"),
                inverseJoinColumns = @JoinColumn(name="book_isbn"))
    private List<Book> books;

    public int getId() { return id;}
    public void setId(int id) {this.id = id;}

    public Timestamp getCreatedAt() {return createdAt; }
    public void setCreatedAt(Timestamp createdAt) {this.createdAt = createdAt;}

    public User getUser_id() {return user_id;}
    public void setUser_id(User user_id) {this.user_id = user_id;}

    public double getTotal() {return total; }
    public void setTotal(double total) {this.total = total;}

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) {this.books = books;}
}
