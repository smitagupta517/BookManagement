package com.library.bookManagement.services;

import com.library.bookManagement.models.Order;
import com.library.bookManagement.models.User;
import com.library.bookManagement.models.requests.OrderRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.library.bookManagement.config.DataConfig.ordersList;

@Service
public class OrderService {
    private final UserService userService;
    private final BookService bookService;

    public OrderService(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    public Order createOrder(OrderRequest orderRequest){
        if(!bookService.checkIfBooksAreAvailable(orderRequest.getBooks())){
            throw new RuntimeException("Books present in this order are not available");
        }
        User user = userService.getUserById(orderRequest.getUserId());
        if(user == null){
            user = userService.createUser(orderRequest.getUserId(), orderRequest.getUserName());
        }
        Integer totalOrderAmount = bookService.getPriceForBooks(orderRequest.getBooks());
        Order newOrder = new Order(UUID.randomUUID().toString(), user.getId(), orderRequest.getBooks(), LocalDateTime.now().toString(), totalOrderAmount);
        ordersList.add(newOrder);
        orderRequest.getBooks().forEach(bookId -> bookService.updateBookStock(bookId, -1));
        return newOrder;
    }
}
