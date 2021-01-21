package com.hkarabakla.services;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.AuthorRepo;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class BookService {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final CategoryRepo categoryRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo, CategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
    }

    public void bookOperations(){
        Book book1=new Book();
        Book book2=new Book();
        Book book3=new Book();


        Author author1=new Author();
        Author author2=new Author();
        Author author3=new Author();

        Category category1=categoryRepo.findByName("bilisim");
        Category category2=categoryRepo.findByName("insaat");
        List<Book> category1Books=category1.getBooks() != null ? category1.getBooks() : new ArrayList<>();
        List<Book> category2Books=category1.getBooks() != null ? category2.getBooks() : new ArrayList<>();
        author1.setName("serdar");
        author2.setName("sukufe");
        author3.setName("recai");

        book1.setIsbn(UUID.randomUUID().toString());
        book2.setIsbn(UUID.randomUUID().toString());
        book3.setIsbn(UUID.randomUUID().toString());

        book1.setCategory(category1);
        book2.setCategory(category1);
        book3.setCategory(category2);

        book1.setCurrency("TL");
        book2.setCurrency("USD");
        book3.setCurrency("EUR");

        book1.setPrice(10.5);
        book2.setPrice(5.3);
        book2.setPrice(15.5);

        book1.setImageUrl("file///123");
        book2.setImageUrl("file///456");
        book3.setImageUrl("file///789");

        book1.setName("Bilisim ve Kultur");
        book2.setName("Bilisim ve Sanat");
        book3.setName("Insaat ve Incelikleri");

        book1.setAddedDate(LocalDate.now());
        book2.setAddedDate(LocalDate.now());
        book3.setAddedDate(LocalDate.now());

        book1.setDescription("Bilisim");
        book2.setDescription("Bilisim");
        book3.setDescription("Insaat");

        book1.setPublishedDate(LocalDate.of(2015,5,5));
        book1.setPublishedDate(LocalDate.of(1990,5,5));
        book1.setPublishedDate(LocalDate.of(2019,12,10));

        book1.setAuthors(Arrays.asList(author1,author2));
        book2.setAuthors(Arrays.asList(author2,author3));

        author1.setBooks(Arrays.asList(book1,book2));
        author2.setBooks(Collections.singletonList(book3));
        author3.setBooks(Collections.singletonList(book3));

        category1Books.add(book1);
        category1Books.add(book2);
        category2Books.add(book3);
        category1.setBooks(category1Books);
        category2.setBooks(category2Books);

        authorRepo.save(author1);
        //authorRepo.save(author2);
        authorRepo.save(author3);
        categoryRepo.save(category1);
        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);


        System.out.println(bookRepo.findByAuthors_Name("serdar"));
        System.out.println(bookRepo.findByAuthors_Name("recai"));
        //System.out.println(bookRepo.findByAuthors_Name("sukufe"));
        System.out.println(bookRepo.findByCategory_Name("bilisim"));

    }
}
