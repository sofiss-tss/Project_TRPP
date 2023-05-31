package com.example.project_trpp.data.datasource.databasedatasourse;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {
    @Insert
    void insert(EventEntity eventEntity);

    @Query("SELECT * FROM events")
    LiveData<List<EventEntity>> getAllEvents();


    @Query("DELETE FROM events")
    void deleteAll();
}
