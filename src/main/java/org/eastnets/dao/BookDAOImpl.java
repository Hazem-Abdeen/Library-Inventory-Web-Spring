package org.eastnets.dao;

import jakarta.persistence.*;
import org.eastnets.model.Book;
import org.eastnets.model.User;
import java.util.List;
import org.eastnets.service.EMFProvider;

public class BookDAOImpl implements BookDAO {

    public void addBook(Book book) {
        EntityManager em = EMFProvider.getEmf().createEntityManager();
        em.getTransaction().begin();
        em.persist(book); // save into the database , insert new record in the table
        em.getTransaction().commit(); // Apply the changes i made and save them in db
        em.close();
    }
//Java Persistence Query Language
    //when retrieving data (especially lists or filtered results)
    public List<Book> viewBooks() {
        EntityManager em = EMFProvider.getEmf().createEntityManager();
        List<Book> list = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        em.close();
        return list;
    }

    public List<Book> searchBookByTitle(String title) {
        EntityManager em = EMFProvider.getEmf().createEntityManager();
        List<Book> list = em.createQuery("SELECT b FROM Book b WHERE LOWER(b.title) LIKE :title", Book.class)
                .setParameter("title", "%" + title.toLowerCase() + "%")
                .getResultList();
        em.close();
        return list;
    }

    public List<Book> searchBookByAuthor(String author) {
        EntityManager em = EMFProvider.getEmf().createEntityManager();
        List<Book> list = em.createQuery("SELECT b FROM Book b WHERE LOWER(b.author) LIKE :author", Book.class)
                .setParameter("author", "%" + author.toLowerCase() + "%")
                .getResultList();
        em.close();
        return list;
    }

    public void deleteBookById(int id) {
        EntityManager em = EMFProvider.getEmf().createEntityManager();
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<Book> getBooksByUser(User user) {
        EntityManager em = EMFProvider.getEmf().createEntityManager();

        List<Book> books = em.createQuery(
                        "SELECT b FROM Book b WHERE b.user = :user", Book.class)
                .setParameter("user", user)
                .getResultList();

        em.close();
        return books;
    }
}