package org.eastnets.bean;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.eastnets.model.Book;
import org.eastnets.service.BookService;
import java.io.Serializable;
import java.util.List;

@Named("bookBean")
@ViewScoped
public class BookBean implements Serializable {

    private Book book = new Book();
    private final BookService bookService = new BookService();

    private int bookId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) { this.bookId = bookId;}

    public void deleteBook() {
        System.out.println("Deleting book BEAN with ID: " + bookId);
        bookService.deleteBook(bookId);
    }

    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    public String addBook() {
        System.out.println("Adding book: ");
        bookService.addBook(book);
        book = new Book(); // Reset form
        return null; // Stay on the same page
    }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

}