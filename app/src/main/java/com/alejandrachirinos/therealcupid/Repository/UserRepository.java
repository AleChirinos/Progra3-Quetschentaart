package com.alejandrachirinos.therealcupid.Repository;

import com.alejandrachirinos.therealcupid.R;
import com.alejandrachirinos.therealcupid.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
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
        //Administrador
        User adminUser = new User("Alejandra", "Chirinos", "chiri", "ale@gmail.com",
                51132, "123", "sistemas", new LinkedList<User>(), 19);
        users.add(adminUser);
        //Usuarios de prueba
        User prueba1 = new User("Pablo", "aaa", "pablo", "pab@gmail.com",
                50000, "123", "sistemas", null, 20);
        User prueba2 = new User("Paola", "aaa", "pablo", "pab@gmail.com",
                50000, "123", "sistemas", null, 20);
        User prueba3 = new User("Pilar", "aaa", "pablo", "pab@gmail.com",
                50000, "123", "sistemas", null, 20);
        User prueba4 = new User("Peter", "aaa", "pablo", "pab@gmail.com",
                50000, "123", "sistemas", null, 20);
        //Imagenes de usuarios de prueba
        prueba1.setImage(R.drawable.photo1);
        prueba2.setImage(R.drawable.photo2);
        prueba3.setImage(R.drawable.photo3);
        prueba4.setImage(R.drawable.photo4);
        //Agregar los usuarios de prueba a contactos del admin
        adminUser.addContact(prueba1);
        adminUser.addContact(prueba2);
        adminUser.addContact(prueba3);
        adminUser.addContact(prueba4);
        //adicionar los usuarios a la lista de usuarios
        users.add(prueba1);
        users.add(prueba2);
        users.add(prueba3);
        users.add(prueba4);

    }
}
