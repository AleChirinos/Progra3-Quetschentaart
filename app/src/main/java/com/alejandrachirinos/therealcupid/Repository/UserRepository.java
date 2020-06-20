package com.alejandrachirinos.therealcupid.Repository;

import com.alejandrachirinos.therealcupid.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;
    private List<User> users = new ArrayList<>();

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        defaultValues();
    }

    public User Login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void register(User user) {
        users.add(user);
    }

    private void defaultValues() {
        User adminUser = new User("Alejandra", "Chirinos", "chiri", "ale@gmail.com",
                51132, "123", "sistemas", null, 19 );
        users.add(adminUser);
    }
}
