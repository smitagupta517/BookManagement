package com.library.bookManagement.services;

import com.library.bookManagement.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.library.bookManagement.config.DataConfig.listOfBooks;
import static com.library.bookManagement.config.DataConfig.ordersList;

@Service
public class BookService {
    private final List<Book> booksData;

    public BookService() {
        this.booksData = listOfBooks;
    }

    public List<Book> getBooksByName(String name){
        return booksData.stream().filter(book -> book.getName().equals(name)).toList();
    }

    public Book getBookById(String id){
        return booksData.stream().filter(book -> book.getId().equals(id)).toList().getFirst();
    }

    public Integer getPriceForBooks(List<String> bookIds){
        AtomicReference<Integer> totalPrice = new AtomicReference<>(0);
        bookIds.forEach(id -> {
            Book book = getBookById(id);
            totalPrice.updateAndGet(v -> v + book.getPrice());
        });
        return totalPrice.get();
    }

    public Boolean checkIfBooksAreAvailable(List<String> bookIds){
        for (String id : bookIds){
            Book book = getBookById(id);
            if(book.getStock() <= 0){
                System.out.println("Book " + book.getName() + "is unavailable");
                return false;
            }
        }
        return true;
    }

    public void updateBookStock(String bookId, Integer quantity){
        Book book = getBookById(bookId);
        Book updatedBook = new Book(book.getId(), book.getName(), book.getAuthor(), book.getVersion(), book.getGenre(), book.getPrice(), book.getStock() + quantity);
        booksData.remove(book);
        booksData.add(updatedBook);
    }
}
