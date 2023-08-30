package com.example.homework_springboot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue
    Integer id;

    Date order_date;

    Date shipped_date;

    String status;

    String comments;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerId")
    Customers customer;

    @OneToMany(mappedBy = "order")
    List<OrderDetails> orderDetails;

}
