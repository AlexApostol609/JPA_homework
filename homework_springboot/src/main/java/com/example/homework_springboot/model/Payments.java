package com.example.homework_springboot.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Payments {
    @Id
    @GeneratedValue
    Integer customer_id;

    Date payment_date;

    Double amount;
    @ManyToOne
    @JoinColumn(name = "payment")
    Customers customer;
}
