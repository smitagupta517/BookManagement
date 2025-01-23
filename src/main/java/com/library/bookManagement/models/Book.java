package com.library.bookManagement.models;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Book {
    String id;
    String name;
    String author;
    String version;
    String genre;
    Integer price;
    Integer stock;
}
