package org.eastnets.dao;

import org.eastnets.model.User;

public interface UserDAO {
    User findByUsernameAndPassword(String username, String password);
}
