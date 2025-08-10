package org.eastnets.dao;

import org.eastnets.model.User;

public interface UserDAO {
    User findByCredentials(String username, String password);
}
