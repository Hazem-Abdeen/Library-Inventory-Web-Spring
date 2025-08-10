package org.eastnets.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.eastnets.model.User;
import org.eastnets.service.EMFProvider;

public class UserDAOImpl implements UserDAO {

    public User findByCredentials(String username, String password) {
        EntityManager em = EMFProvider.getEmf().createEntityManager();

        try {
            User user = em.createQuery("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)", User.class)
                    .setParameter("username", username)
                    .getSingleResult();

            if (user.getPassword().equals(password)) {
                return user;
            }

            return null;

        } catch (NoResultException e) {
            System.out.println("No user found with username: " + username);
            return null;
        } finally {
            em.close();
        }
    }
}
