package org.eastnets.dao;

import jakarta.persistence.*;
import org.eastnets.model.Book;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("libraryPU");

    public void addBook(Book book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }
//Java Persistence Query Language
    //when retrieving data (especially lists or filtered results)
    public List<Book> viewBooks() {
        EntityManager em = emf.createEntityManager();
        List<Book> list = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        em.close();
        return list;
    }

    public List<Book> searchBookByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        List<Book> list = em.createQuery("SELECT b FROM Book b WHERE LOWER(b.title) LIKE :title", Book.class)
                .setParameter("title", "%" + title.toLowerCase() + "%")
                .getResultList();
        em.close();
        return list;
    }

    public List<Book> searchBookByAuthor(String author) {
        EntityManager em = emf.createEntityManager();
        List<Book> list = em.createQuery("SELECT b FROM Book b WHERE LOWER(b.author) LIKE :author", Book.class)
                .setParameter("author", "%" + author.toLowerCase() + "%")
                .getResultList();
        em.close();
        return list;
    }

    public void deleteBookById(int id) {
        System.out.println("Deleting book IMP with id: " + id);
        EntityManager em = emf.createEntityManager();
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }
        em.close();
    }
}
