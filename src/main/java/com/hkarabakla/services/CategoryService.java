package com.hkarabakla.services;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void addCategory(String...name){
        for(String s:name){
            Category category=new Category();
            category.setName(s);
            categoryRepo.save(category);
            System.out.println(categoryRepo.findByName(s));
        }

    }
    public void deleteCategory(String name){
        Category category=categoryRepo.findByName(name);
        categoryRepo.delete(category);
    }

    public void updateCategory(String oldName,String newName){
        Category category=categoryRepo.findByName(oldName);
        category.setName(newName);
        categoryRepo.save(category);
    }

    public void categoryOperations() {


    }
}
