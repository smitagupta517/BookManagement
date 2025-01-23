package com.library.bookManagement.models;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;


@AllArgsConstructor
@Value
public class User {
    String id;
    String name;
    List<String> orders;
}
