package com.example.homework_springboot.controller;

import com.example.homework_springboot.model.Customers;
import com.example.homework_springboot.model.Orders;
import com.example.homework_springboot.service.CustomersService;
import com.example.homework_springboot.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @Autowired
    CustomersService customersService;

    @GetMapping(value = "/orders/{customer_Id}")
    public List<Orders> getAllOrdersByCustomer(@PathVariable Integer customer_Id){
        Customers customer = customersService.findById(customer_Id);
        return ordersService.getAllOrdersByCustomer(customer);
    }

    @PostMapping(value= "/orders/addProducts/{customerId}")
    public void addProductsToOrderOfCustomer(@PathVariable Integer customerId){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the id's of the products you want to add to the customer (type stop to end)");
        List<String> productList = new ArrayList<>();
        while(true){
            String input = sc.nextLine();
            if(input.equals("stop")){
                break;
            }
            productList.add(input);
        }
        ordersService.addProductsToOrderOfCustomer(customerId, productList );
    }
}
