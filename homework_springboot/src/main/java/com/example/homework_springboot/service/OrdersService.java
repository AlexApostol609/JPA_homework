package com.example.homework_springboot.service;

import com.example.homework_springboot.model.Customers;
import com.example.homework_springboot.model.OrderDetails;
import com.example.homework_springboot.model.Orders;
import com.example.homework_springboot.model.Products;
import com.example.homework_springboot.repository.CustomersRepository;
import com.example.homework_springboot.repository.OrderDetailsRepository;
import com.example.homework_springboot.repository.OrdersRepository;
import com.example.homework_springboot.repository.ProductsRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public void addProductsToOrderOfCustomer(Integer customerId, List<String> productCodes){
        Customers customer = customersRepository.findById(customerId).orElse(null);
        List<Products> products = productsRepository.findByCodeIn(productCodes);
        if(customer != null && !products.isEmpty())
        {
            Orders order = new Orders();
            Date x = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x);
            calendar.add(Calendar.MONTH, 10);
            Date dateTenMonthsLater = calendar.getTime();
            order.setOrder_date(x);
            order.setStatus("Pending");
            order.setCustomer(customer);
            order.setShipped_date(dateTenMonthsLater);
            ordersRepository.save(order);
            for(Products product : products)
            {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setProduct(product);
                orderDetails.setPriceEach(product.getPrice());
                orderDetails.setQuantity(1);
                orderDetails.setOrder(order);
                orderDetailsRepository.save(orderDetails);
            }

            customer.getOrdersList().add(order);

            customersRepository.save(customer);
        }

    }

    public List<Orders> getAllOrdersByCustomer(Customers customer) {
        return ordersRepository.findAllByCustomer(customer);
    }




}
