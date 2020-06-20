package com.alejandrachirinos.therealcupid.Repository;

import com.alejandrachirinos.therealcupid.model.User;

public class UserRepository {
    public User Login(String username, String password) {
        if(username.equals("admi") && password.equals("123")) {
            User user = new User(52334, "admi", "erickmallea",
                    52334, "123","systems", null, 18);
            return user;
        } else {
            return null;

        }
    }



}
