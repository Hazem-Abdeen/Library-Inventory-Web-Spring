package org.eastnets.service;

import org.eastnets.dao.UserDAO;
import org.eastnets.dao.UserDAOImpl;
import org.eastnets.model.User;

public class AuthService {

    private final UserDAO userDAO = new UserDAOImpl();

    public User authenticate(String username, String password) {
        // You can add extra logic here later (e.g., log attempts, hash password, etc.)
        return userDAO.findByUsernameAndPassword(username, password);
    }
}
