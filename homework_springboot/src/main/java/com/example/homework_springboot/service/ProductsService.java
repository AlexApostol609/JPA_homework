package com.example.homework_springboot.service;

import com.example.homework_springboot.model.Products;
import com.example.homework_springboot.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    public void InsertProduct(Products p){
        productsRepository.save(p);
    }

    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }
}
