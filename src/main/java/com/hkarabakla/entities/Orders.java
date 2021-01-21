package com.hkarabakla.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate created_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    private double total;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_book",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private List<Book> books;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getCreated_at() {return created_at;}
    public void setCreated_at(LocalDate created_at) {this.created_at = created_at;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public double getTotal() {return total;}
    public void setTotal(double total) {this.total = total;}

    public List<Book> getBooks() {return books;}
    public void setBooks(List<Book> books) {this.books = books;}

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", total=" + total +
                ", books=" + books +
                ", user="+user+
                '}';
    }
}
