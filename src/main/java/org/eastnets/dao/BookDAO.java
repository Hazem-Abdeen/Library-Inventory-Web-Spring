package org.eastnets.dao;
import org.eastnets.model.Book;
import org.eastnets.model.User;

import java.util.List;

public interface BookDAO {

    void addBook(Book book);
    List<Book> viewBooks();
    List<Book> searchBookByTitle(String title);
    List<Book> searchBookByAuthor(String author);
    void deleteBookById(int id);
    List<Book> getBooksByUser(User user);

}
