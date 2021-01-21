package com.hkarabakla.repositories;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepo extends CrudRepository<Author,Integer> {

    public List<Author> findAllByBooks_Name(String bookName);
    public List<Author> findAllByBooks_Isbn(String bookName);
    public List<Author> findAllByBooks_Category_Name(String categoryName);

}
