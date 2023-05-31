package com.example.project_trpp.data.repository;

import android.app.Application;
import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.netwoevents.data.datasource.databasedatasourse.AppDatabase;
import com.example.netwoevents.data.datasource.databasedatasourse.EventDao;
import com.example.netwoevents.data.datasource.databasedatasourse.EventEntity;
import com.example.netwoevents.data.datasource.models.Event;

import java.util.List;
import java.util.stream.Collectors;

public class EventRepository  {
    private EventDao eventDao;
    private LiveData<List<Event>> allEvents;

    public EventRepository(Application application) {

        AppDatabase db = AppDatabase.getDatabase(application);
        eventDao = db.eventDao();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            allEvents = Transformations.map(eventDao.getAllEvents(),
                    entities -> entities.stream().map(EventEntity::toEvent).collect(Collectors.toList()));
        }
    }
    public LiveData<List<Event>> getAllEvents() {
        return allEvents;
    }
    public void insert(Event event) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            eventDao.insert(new EventEntity(event.getTitle(), event.getLocation(),
                    event.getDateBegin().getTimeInMillis(), event.getDateEnd().getTimeInMillis()));
        });
    }
}
