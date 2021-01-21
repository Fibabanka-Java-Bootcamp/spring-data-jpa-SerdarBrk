package com.hkarabakla.services;

import com.hkarabakla.entities.Orders;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.OrdersRepo;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class OrdersService {
    private final OrdersRepo ordersRepo;
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public OrdersService(OrdersRepo ordersRepo, BookRepo bookRepo, UserRepo userRepo) {
        this.ordersRepo = ordersRepo;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public void orderOperations(){
        Orders orders=new Orders();
        orders.setUser(userRepo.findByName("user"));
        orders.setBooks(Arrays.asList(bookRepo.findByName("Bilisim ve Kultur")));
        orders.setTotal(bookRepo.findByName("Bilisim ve Kultur").getPrice());
        orders.setCreated_at(LocalDate.now());
        ordersRepo.save(orders);
        System.out.println(ordersRepo.findByUser(userRepo.findByName("user")));
    }

}
