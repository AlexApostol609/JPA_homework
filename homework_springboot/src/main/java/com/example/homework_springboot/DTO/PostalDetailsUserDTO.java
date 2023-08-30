package com.example.homework_springboot.DTO;

import com.example.homework_springboot.model.Customers;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class PostalDetailsUserDTO {


    String phone;

    String address;

    String city;

    public PostalDetailsUserDTO(Customers c){
        this.phone=c.getPhone();
        this.address=c.getAddress();
        this.city=c.getCity();
    }
}
