package com.example.homework_springboot.repository;

import com.example.homework_springboot.DTO.PostalDetailsUserDTO;
import com.example.homework_springboot.model.Customers;
import com.example.homework_springboot.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {


    Customers findByUsername(String username);

    @Query("SELECT new com.example.homework_springboot.DTO.PostalDetailsUserDTO(c.phone, c.address, c.city) FROM Customers c WHERE c.username = :username")
    PostalDetailsUserDTO getPostalDetailsByUsername(@Param("username") String username);
}
