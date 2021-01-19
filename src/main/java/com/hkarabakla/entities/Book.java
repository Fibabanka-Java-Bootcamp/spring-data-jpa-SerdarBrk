package com.hkarabakla.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Book {

    @Id
    private String isbn;

    private String name;

    private String description;

    private Timestamp publishedDate;

    private Timestamp addedDate;

    private double price;

    private String currency;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    @ManyToMany(mappedBy = "books",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Order> orders;

    @ManyToMany(mappedBy = "books",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Author> authors;

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getOrders() {return orders;}
    public void setOrders(List<Order> orders) {this.orders = orders;}

    public List<Author> getAuthors() {return authors;}
    public void setAuthors(List<Author> authors) {this.authors = authors;}

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                ", addedDate=" + addedDate +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", authors=" + authors +
                '}';
    }
}
