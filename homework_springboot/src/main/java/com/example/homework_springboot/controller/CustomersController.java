package com.example.homework_springboot.controller;

import com.example.homework_springboot.DTO.PostalDetailsUserDTO;
import com.example.homework_springboot.model.Customers;
import com.example.homework_springboot.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {
    @Autowired
    CustomersService customersService;

    @PostMapping(value = "/insertCustomer")
    public void insertCustomer(){
        Customers c = new Customers();
        c.setUsername("MihailB14");
        c.setFirst_name("Mihail");
        c.setLast_name("Barbulescu");
        c.setPhone("0773844123");
        c.setAddress("Bd. Tineretului");
        c.setCity("Bucuresti");
        c.setPostalCode("123456");
        c.setCountry("Romania");
        customersService.createCustomer(c);
    }
    @PostMapping(value = "/insertCustomer2")
    public void insertCustomer2(){
        Customers c = new Customers();
        c.setUsername("alexapo");
        c.setFirst_name("Alex");
        c.setLast_name("Apostol");
        c.setPhone("073451223");
        c.setAddress("Bd. Crangasi");
        c.setCity("Bucuresti");
        c.setPostalCode("12312344");
        c.setCountry("Romania");
        customersService.createCustomer(c);
    }

    @GetMapping(value = "/customer/{username}")
    public PostalDetailsUserDTO getPostalDetails(@PathVariable String username ) {
        return customersService.getPostalDetails(username);
    }


}
