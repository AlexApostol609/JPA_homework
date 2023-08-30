package com.example.homework_springboot.repository;

import com.example.homework_springboot.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String> {
    List<Products> findByCodeIn(List<String> productCodes);

}
