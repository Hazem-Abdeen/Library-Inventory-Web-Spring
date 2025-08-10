package org.eastnets.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eastnets.model.Book;
import org.eastnets.service.BookService;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("bookBean")
public class BookBean implements Serializable {

    @Inject
    private LoginBean loginBean;

    private Book book = new Book();

    private final BookService bookService = new BookService();

    private int bookId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) { this.bookId = bookId;}

    public void deleteBook() { bookService.deleteBook(bookId); }

    public List<Book> getBooks() {
        return bookService.getBooksByUser(loginBean.getUser());
    }

     public void addBook() {
        book.setUser(loginBean.getUser());
        bookService.addBook(book);
        book = new Book(); // Reset form

    }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

}