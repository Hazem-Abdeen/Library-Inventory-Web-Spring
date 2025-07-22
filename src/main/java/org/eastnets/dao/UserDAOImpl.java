package org.eastnets.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import org.eastnets.model.User;

public class UserDAOImpl implements UserDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("libraryPU");

    public User findByUsernameAndPassword(String username, String password) {
        EntityManager em = emf.createEntityManager(); //to start the sission

        try {
            return em.createQuery("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username) AND u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult(); // am expecting a single result, so if non or more than one throw exception

        } catch (NoResultException e) {
            System.out.println("No user found with username: " + username + " and password: " + password);
            return null;
        } finally {
            em.close();
        }
    }
}
