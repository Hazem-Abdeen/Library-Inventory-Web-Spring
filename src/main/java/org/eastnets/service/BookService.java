package org.eastnets.service;

import org.eastnets.dao.BookDAO;
import org.eastnets.dao.BookDAOImpl;
import org.eastnets.model.Book;
import org.eastnets.model.User;

import java.util.List;

public class BookService {

    private final BookDAO bookDAO;

    public BookService() {
        this.bookDAO = new BookDAOImpl();
    }

    public void addBook(Book book) {
        if (validate(book)) {
            bookDAO.addBook(book);
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Invalid book data.");
        }
    }

    public List<Book> getAllBooks() {
        return bookDAO.viewBooks();
    }

    public List<Book> searchByTitle(String title) {
        if (title == null || title.trim().isEmpty()) return List.of();
        return bookDAO.searchBookByTitle(title.trim());
    }

    public List<Book> searchByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) return List.of();
        return bookDAO.searchBookByAuthor(author.trim());
    }

    public void deleteBook(int id) {
        System.out.println("Deleting book SERVICE with ID: " + id);
        if (id > 0) {
            bookDAO.deleteBookById(id);
        }
    }
        public List<Book> getBooksByUser(User user){
        if (user == null) {
            System.out.println("User is null, cannot retrieve books.");
            return List.of();
        }
        return bookDAO.getBooksByUser(user);
    }

    private boolean validate(Book book) {
        if (book == null) {
            return false;
        }

        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            System.out.println("Validation failed: Title is required.");
            return false;
        }

        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            System.out.println("Validation failed: Author is required.");
            return false;
        }

        return true;
    }


}
