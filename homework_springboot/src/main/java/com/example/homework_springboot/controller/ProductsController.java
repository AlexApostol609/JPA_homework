package com.example.homework_springboot.controller;

import com.example.homework_springboot.model.Products;
import com.example.homework_springboot.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @PostMapping(value = "/insertProduct1")
    public void InsertProduct1(){
        Products p = new Products();
        p.setName("Coca-Cola");
        p.setStock(100);
        p.setDescription("Un suc foarte foarte bun!");
        p.setPrice(7.99);
        productsService.InsertProduct(p);
    }
    @PostMapping(value = "/insertProduct2")
    public void InsertProduct2(){
        Products p = new Products();
        p.setName("Fanta");
        p.setStock(110);
        p.setDescription("cica e suc de portocale dar are 1% pulpa");
        p.setPrice(9.03);
        productsService.InsertProduct(p);
    }
    @PostMapping(value = "/insertProduct3")
    public void InsertProduct3(){
        Products p = new Products();
        p.setName("Lays");
        p.setStock(50);
        p.setDescription("cam sarate");
        p.setPrice(15.23);
        productsService.InsertProduct(p);
    }
    @PostMapping(value = "/insertProduct4")
    public void InsertProduct4(){
        Products p = new Products();
        p.setName("Guma de mestecat");
        p.setStock(200);
        p.setDescription("dulce");
        p.setPrice(3.01);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct5")
    public void InsertProduct5(){
        Products p = new Products();
        p.setName("Sticks-uri cu ciocolata");
        p.setStock(130);
        p.setDescription("si dulci si sarate");
        p.setPrice(6.32);
        productsService.InsertProduct(p);
    }

    @PostMapping(value = "/insertProduct6")
    public void InsertProduct6(){
        Products p = new Products();
        p.setName("Margarina");
        p.setStock(10);
        p.setDescription("pt paine");
        p.setPrice(3.21);
        productsService.InsertProduct(p);
    }


    @GetMapping(value = "/products")
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

}
