package com.example.homework_springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

@Entity
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue
    Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="productCode")
    Products product;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="orderNumber")
    Orders order;

    Integer quantity;

    Double priceEach;


}
