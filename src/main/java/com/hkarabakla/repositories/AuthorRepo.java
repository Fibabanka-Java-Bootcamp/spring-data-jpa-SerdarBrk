package com.hkarabakla.repositories;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorRepo extends CrudRepository<Author,Integer> {
    public Author findByName(String name);
    public Author findByBooks(Book book);

    @Modifying
    @Query("update Author a set a.name= :name where a.id=:id")
    public void updateAuthorName(@Param(value="id") int id, @Param(value = "name")String name);
}
