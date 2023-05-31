package com.example.project_trpp.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.netwoevents.data.datasource.models.Event;
import com.example.netwoevents.data.repository.EventRepository;

import java.util.List;

public class EventViewModel extends AndroidViewModel {
    private EventRepository eventRepository;

    private final LiveData<List<Event>> allEvents;

    public LiveData<List<Event>> getAllEvents() { return allEvents; }

    public EventViewModel (Application application) {
        super(application);
        eventRepository = new EventRepository(application);
        allEvents = eventRepository.getAllEvents();
    }

    public void insert(Event event) { eventRepository.insert(event); }
}
