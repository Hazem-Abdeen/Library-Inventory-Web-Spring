/*
package org.eastnets.bean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import org.eastnets.model.Book;
import org.eastnets.service.BookService;

import java.util.List;

@ManagedBean
@RequestScoped
public class BookBean {

    private Book book = new Book();
    private final BookService bookService = new BookService();

    public String addBook() {
        bookService.addBook(book);
        book = new Book(); // reset the form
        return "books.xhtml?faces-redirect=true";
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Getters and Setters
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
*/