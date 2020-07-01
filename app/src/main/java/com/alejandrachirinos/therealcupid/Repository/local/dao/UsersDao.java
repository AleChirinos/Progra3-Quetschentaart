package com.alejandrachirinos.therealcupid.Repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.alejandrachirinos.therealcupid.model.User;

@Dao
public interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(User user);

    @Query("DELETE FROM User")
    void deleteAll();

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateEntry(User user);

    @Query("SELECT * FROM User ORDER BY RANDOM() LIMIT 1")
    LiveData<User> getRandom();

    @Query("SELECT count(0) FROM User")
    int getCount();


}
