package com.example.homework_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class  Customers {

    @Id
    @GeneratedValue
    Integer id;

    String username;

    String last_name;

    String first_name;

    String phone;

    String address;

    String city;

    String postalCode;

    String country;

    @OneToMany(mappedBy = "customer")
    List<Orders> ordersList;

    @OneToMany(mappedBy = "customer")
    List<Payments> payment;
}

