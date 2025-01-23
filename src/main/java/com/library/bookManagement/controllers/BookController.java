package com.library.bookManagement.controllers;

import com.library.bookManagement.models.Book;
import com.library.bookManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @Autowired private BookService bookService;

    @QueryMapping("getBookByName")
    public List<Book> getBooksByName(@Argument String name){
        return bookService.getBooksByName(name);
    }
}
