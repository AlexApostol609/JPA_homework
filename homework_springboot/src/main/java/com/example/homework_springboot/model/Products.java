package com.example.homework_springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String code;

    String name;

    String description;

    Integer stock;

    Double price;

    @OneToMany(mappedBy = "product")
    List<OrderDetails> orderDetailsList;


}
