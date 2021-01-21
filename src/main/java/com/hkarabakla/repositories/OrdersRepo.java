package com.hkarabakla.repositories;

import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepo extends CrudRepository<Orders,Integer> {
    public List<Orders> findAllByUser_Name(String name);
    public List<Orders> findAllByBooks_Category_Name(String name);
    public List<Orders> findAllByBooks_NameContainingIgnoreCase(String name);
    public List<Orders> findAllByBooks_Authors_Name(String name);
}
