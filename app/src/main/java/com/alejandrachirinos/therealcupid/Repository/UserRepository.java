package com.alejandrachirinos.therealcupid.Repository;

import com.alejandrachirinos.therealcupid.model.User;

public class UserRepository {
    public User login(String username, String password) {
        if (username.equals("admi") && password.equals("123")) {
            User user = new User("admi", username,123, "sistemas", "123",null);
            return user;
        } else {
            return null;
        }
    }
}
