package com.hkarabakla.services;

import com.hkarabakla.entities.Address;
import com.hkarabakla.entities.User;
import com.hkarabakla.repositories.AddressRepo;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepo userRepo;
    private final AddressRepo addressRepo;

    public UserService(UserRepo userRepo, AddressRepo addressRepo) {
        this.userRepo = userRepo;
        this.addressRepo = addressRepo;
    }

    public void userOperations() {
        User u = new User();
        User u1 = new User();
        u.setName("user");
        u1.setName("serdar");
        Address address = new Address();
        address.setStreet("Gazo sokak");
        address.setNumber("7");
        address.setZipcode(34);
        address.setCity("Istanbul");

        Address address1 = new Address();
        address1.setStreet("Demetgül sokak");
        address1.setNumber("5");
        address1.setZipcode(6);
        address1.setCity("Ankara");


        u.setAddress(address);
        u1.setAddress(address1);
        address.setUser(u);
        address1.setUser(u1);
        userRepo.save(u);
        userRepo.save(u1);

        addressRepo.save(address);
        addressRepo.save(address1);

        System.out.println(userRepo.findAllByNameContainingIgnoreCase("se"));
        System.out.println(userRepo.findAllByAddress_City("Istanbul"));
        System.out.println(userRepo.findAllByAddress_Street("Demetgül sokak"));
        System.out.println(userRepo.findAllByAddress_StreetContainingIgnoreCase("sokak"));
    }
}
