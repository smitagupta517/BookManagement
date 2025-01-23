package com.library.bookManagement.controllers;

import com.library.bookManagement.models.Order;
import com.library.bookManagement.models.requests.OrderRequest;
import com.library.bookManagement.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @MutationMapping("createOrder")
    public Order createOrder(@Argument("orderRequest") OrderRequest orderRequest){
        return orderService.createOrder(orderRequest);
    }
}
