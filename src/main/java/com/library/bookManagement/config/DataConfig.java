package com.library.bookManagement.config;

import com.library.bookManagement.models.Book;
import com.library.bookManagement.models.Order;
import com.library.bookManagement.models.User;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class DataConfig {

    public static final List<Book> listOfBooks = getBooks();
    public static final List<User> usersList = getUsers();
    public static final List<Order> ordersList = new ArrayList<>();
    
    private static List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", "BookA", "Test1", "3", "fiction",100, 10));
        books.add(new Book("Book2", "BookB", "Test2", "3", "science",500, 10));
        books.add(new Book("Book3", "BookC", "Test3", "3", "romance",180, 10));
        books.add(new Book("Book4", "BookD", "Test4", "3", "science",270, 10));
        books.add(new Book("Book5", "BookE", "Test5", "3", "non-fiction",350, 10));
        return books;
    }
    
    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("1", "Amy", new ArrayList<>()));
        users.add(new User("2", "Sheldon", new ArrayList<>()));
        users.add(new User("3", "Leonard", new ArrayList<>()));
        users.add(new User("4", "Penny", new ArrayList<>()));
        users.add(new User("5", "Rajesh", new ArrayList<>()));
        users.add(new User("6", "Howard", new ArrayList<>()));
        users.add(new User("7", "Bernadette", new ArrayList<>()));
        return users;
    }
}
