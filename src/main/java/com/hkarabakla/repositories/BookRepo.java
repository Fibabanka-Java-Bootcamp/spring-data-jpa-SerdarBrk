package com.hkarabakla.repositories;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book,String> {
    Book findByName(String name);
    Book findByIsbn(String isbn);
    List<Book> findByAuthors_Name(String name);
    List<Book> findByCategory_Name(String name);
}
