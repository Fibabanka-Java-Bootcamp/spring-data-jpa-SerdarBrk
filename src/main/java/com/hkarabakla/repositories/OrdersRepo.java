package com.hkarabakla.repositories;

import com.hkarabakla.entities.Orders;
import com.hkarabakla.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders,Integer> {
    public Orders findByUser(User user);
}
