package com.hkarabakla;

import com.hkarabakla.services.BookService;
import com.hkarabakla.services.CategoryService;
import com.hkarabakla.services.OrdersService;
import com.hkarabakla.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.hkarabakla");
        appContext.refresh();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();

        CategoryService categoryService = (CategoryService) appContext.getBean("categoryService");
        categoryService.addCategory("bilisim","elektronik","insaat","bilim kurgu","sinav");

        BookService bookService=(BookService)appContext.getBean("bookService");
        bookService.bookOperations();


        OrdersService ordersService=(OrdersService)appContext.getBean("ordersService");
        ordersService.orderOperations();
        appContext.close();
    }
}
