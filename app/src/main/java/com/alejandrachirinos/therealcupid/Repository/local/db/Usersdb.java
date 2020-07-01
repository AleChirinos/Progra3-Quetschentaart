package com.alejandrachirinos.therealcupid.Repository.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.alejandrachirinos.therealcupid.Repository.local.dao.UsersDao;
import com.alejandrachirinos.therealcupid.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class Usersdb extends RoomDatabase {
    public abstract UsersDao usersDao();
    private static volatile Usersdb INSTANCE;

    static public Usersdb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Usersdb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Usersdb.class, "users_database.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
