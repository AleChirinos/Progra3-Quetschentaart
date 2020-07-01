package com.alejandrachirinos.therealcupid.Repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.alejandrachirinos.therealcupid.R;
import com.alejandrachirinos.therealcupid.model.User;
import com.google.gson.Gson;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class UserRepository {

    private SharedPreferences preferences;
    private Context context;
    private List<User> users = new ArrayList<>();

    public UserRepository(Context context) {
        //Paso 1: Cuando la instancia de UserRepository se crea, llenamos nuestra variable de preferencias
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultValues();
    }

    public User Login(String username, String password) {
        String userLogging = null;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        if (preferences.contains(username)) {
            userLogging = preferences.getString(username, null);
            Log.e("Ultimo acceso", userLogging);

        }
        if (userLogging != null) {
            //String --> Obj (deserializar)
            User user2 = new Gson().fromJson(userLogging, User.class);
            if(password.equals(user2.getPassword()))
            return user2;
        }
        return null;
    }

    public void register(User user) {
        if(!preferences.contains(user.getUsername())){
            users.add(user);
            String userLoggedString = new Gson().toJson(user);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(user.getUsername(), userLoggedString);
            editor.apply();
        }
    }
    public void setUsuarioActivo(User user){
        String usuarioActivo = new Gson().toJson(user);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuarioActivo",usuarioActivo);
        editor.putString(user.getUsername(),usuarioActivo);
        editor.apply();
    }
    public User getUsuarioActivo(){
        String usuarioActivoString = preferences.getString("usuarioActivo",null);
        User usuarioActivo = new Gson().fromJson(usuarioActivoString, User.class);
        return usuarioActivo;
    }
    public void setUserLogged(User userLogged) {
        String userLoggedString = new Gson().toJson(userLogged);

        //Editor y guardamos el string
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", userLoggedString);

        //Guardamos fecha y hora en miliseconds.
        editor.putLong("timestamp", Calendar.getInstance().getTime().getTime());
        editor.apply();
    }

    public User getUserLogged() {
        if (preferences.contains("user")) {
            String userLoggedString = preferences.getString("user", null);
            if (userLoggedString != null) {

                //Mostrar ultimo Login
                if (preferences.contains("timestamp")) {
                    long timestamp = preferences.getLong("timestamp", 0);
                    Date date = new Date(timestamp);
                    Log.e("Ultimo acceso", date.toLocaleString());
                }


                //String --> Obj (deserializar)
                User userLogged = new Gson().fromJson(userLoggedString, User.class);
                return userLogged;
            }
        }

        return null;
    }

    public void deleteUserLogged() {
        //Editor y eliminamos el valor
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("user");
        editor.apply();
    }
    private void defaultValues() {
        //Administrador
        User adminUser = new User("Alejandra", "Chirinos", "chiri", "ale@gmail.com",
                51132, "123", "sistemas",19);
        users.add(adminUser);
        //Usuarios de prueba
        User prueba1 = new User("Pablo", "aaa", "pablo", "pab@gmail.com",
                50000, "123", "sistemas",20);
        User prueba2 = new User("Paola", "aaa", "paola", "pab@gmail.com",
                50000, "123", "sistemas",20);
        User prueba3 = new User("Pilar", "aaa", "pilar", "pab@gmail.com",
                50000, "123", "sistemas",20);
        User prueba4 = new User("Peter", "aaa", "peter", "pab@gmail.com",
                50000, "123", "sistemas",20);
        User prueba5 = new User("Pietro", "aaa", "pablo", "pab@gmail.com",
                50000, "123", "sistemas",20);
        //Imagenes de usuarios de prueba
        prueba1.setImage(R.drawable.photo1);
        prueba2.setImage(R.drawable.photo2);
        prueba3.setImage(R.drawable.photo3);
        prueba4.setImage(R.drawable.photo4);
        prueba5.setImage(R.drawable.photo5);

        //Agregar los usuarios de prueba a contactos del admin
        adminUser.addContact(prueba1);
        adminUser.addContact(prueba2);
        adminUser.addContact(prueba3);
        adminUser.addContact(prueba4);
        adminUser.addContact(prueba5);

        //adicionar los usuarios a la lista de usuarios
        users.add(prueba1);
        users.add(prueba2);
        users.add(prueba3);
        users.add(prueba4);
        users.add(prueba5);

    }
}
