package com.alejandrachirinos.therealcupid.Repository.local;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.alejandrachirinos.therealcupid.R;
import com.alejandrachirinos.therealcupid.Repository.local.db.Usersdb;
import com.alejandrachirinos.therealcupid.activity_random;
import com.alejandrachirinos.therealcupid.model.User;

public class OtherUsersRepository {
    private Usersdb db;
    public static String LOG = activity_random.class.getName();

    public OtherUsersRepository(Application application) {

        db = Usersdb.getDatabase(application);
        llenarDB();
    }
    public void insert(final User user) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db.usersDao().insert(user);
            }
        });
        thread.start();
    }

    public void updateEntry(final User user) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db.usersDao().updateEntry(user);
            }
        });
        thread.start();
    }

    public void deleteAll() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db.usersDao().deleteAll();
            }
        });
        thread.start();
    }
    public LiveData<User> getRandom() {
        return db.usersDao().getRandom();
    }

    public int getCount() {
        int result=db.usersDao().getCount();
                Log.e(LOG, result+"");

        return result;
    }

    public void llenarDB(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int contador = getCount();
                if(getCount()<10){
                    //Usuarios de prueba
                    User prueba1 = new User("Ana", "aaa", "Ana", "pab@gmail.com",
                            50000, "123", "Sistemas",20);
                    User prueba2 = new User("Antonella", "aaa", "Antonella", "pab@gmail.com",
                            50001, "123", "Electronica",18);
                    User prueba3 = new User("Alice", "aaa", "Alice", "pab@gmail.com",
                            50002, "123", "Sistemas",17);
                    User prueba4 = new User("Ariana", "aaa", "Ariana", "pab@gmail.com",
                            50003, "123", "Derecho",25);
                    User prueba5 = new User("Astrid", "aaa", "Astrid", "pab@gmail.com",
                            50004, "123", "Ambiental",22);
                    User prueba6 = new User("Antonio", "aaa", "Antonio", "pab@gmail.com",
                            50005, "123", "Medicina",23);
                    User prueba7 = new User("Aaron", "aaa", "Aaron", "pab@gmail.com",
                            50006, "123", "Comercial",20);
                    User prueba8 = new User("Alejandro", "aaa", "Alejandro", "pab@gmail.com",
                            50007, "123", "Turismo",21);
                    User prueba9 = new User("Armando", "aaa", "Armando", "pab@gmail.com",
                            50008, "123", "Sistemas",18);
                    User prueba10 = new User("Ash", "aaa", "Ash", "pab@gmail.com",
                            50009, "123", "Electronica",19);
                    //Imagenes de usuarios de prueba
                    prueba1.setImage(R.drawable.dbphoto1);
                    prueba2.setImage(R.drawable.dbphoto2);
                    prueba3.setImage(R.drawable.dbphoto3);
                    prueba4.setImage(R.drawable.dbphoto4);
                    prueba5.setImage(R.drawable.dbphoto5);
                    prueba6.setImage(R.drawable.dbphoto6);
                    prueba7.setImage(R.drawable.dbphoto7);
                    prueba8.setImage(R.drawable.dbphoto8);
                    prueba9.setImage(R.drawable.dbphoto9);
                    prueba10.setImage(R.drawable.dbphoto10);
                    //Generos
                    prueba1.setEsMujer(true);
                    prueba2.setEsMujer(true);
                    prueba3.setEsMujer(true);
                    prueba4.setEsMujer(true);
                    prueba5.setEsMujer(true);
                    prueba6.setEsHombre(true);
                    prueba7.setEsHombre(true);
                    prueba8.setEsHombre(true);
                    prueba9.setEsHombre(true);
                    prueba10.setEsHombre(true);
                    //Intereses
                    prueba1.setHombres(true);
                    prueba2.setHombres(true);
                    prueba3.setHombres(true);
                    prueba4.setHombres(true);
                    prueba5.setHombres(true);
                    prueba6.setMujeres(true);
                    prueba7.setMujeres(true);
                    prueba8.setMujeres(true);
                    prueba9.setMujeres(true);
                    prueba10.setMujeres(true);
                    //Agregar a la base de datos
                    insert(prueba1);
                    insert(prueba2);
                    insert(prueba3);
                    insert(prueba4);
                    insert(prueba5);
                    insert(prueba6);
                    insert(prueba7);
                    insert(prueba8);
                    insert(prueba9);
                    insert(prueba10);
                }            }
        });
        thread.start();
    }
}
