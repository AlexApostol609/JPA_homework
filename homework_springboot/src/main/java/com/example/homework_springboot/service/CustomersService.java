package com.example.homework_springboot.service;

import com.example.homework_springboot.DTO.PostalDetailsUserDTO;
import com.example.homework_springboot.model.Customers;
import com.example.homework_springboot.repository.CustomersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    @Autowired
    CustomersRepository customersRepository;

    public Customers findById(Integer id){
        return customersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer with ID " + id + " not found"));
    }

    public void createCustomer(Customers c){
        customersRepository.save(c);
    }

    public PostalDetailsUserDTO getPostalDetails(String username){
        Customers customer = customersRepository.findByUsername(username);
        PostalDetailsUserDTO CustomerDTO = new PostalDetailsUserDTO(customer);
        return CustomerDTO;
    }

}
