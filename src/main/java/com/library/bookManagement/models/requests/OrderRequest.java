package com.library.bookManagement.models.requests;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
public class OrderRequest {
    List<String> books;
    String userId;
    String userName;
}
