package com.example.homework_springboot.repository;

import com.example.homework_springboot.model.Customers;
import com.example.homework_springboot.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> getAllOrdersByCustomerId(Integer customer_id);

    List<Orders> findAllByCustomer(Customers customer);
}
