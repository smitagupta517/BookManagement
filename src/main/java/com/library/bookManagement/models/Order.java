package com.library.bookManagement.models;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;


@AllArgsConstructor
@Value
public class Order {
    String id;
    String userId;
    List<String> books;
    String orderCreatedTs;
    Integer totalAmount;
}
