package com.example.project_trpp.data.datasource.databasedatasourse;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.netwoevents.data.datasource.models.Event;

import java.util.Calendar;


@Entity(tableName = "events")
    public class EventEntity{
        @PrimaryKey(autoGenerate = true)
        private int id;
        private String title;
        private String location;
        private long dateBegin;
        private long dateEnd;
        public EventEntity(@NonNull String title, @NonNull String location,
                           @NonNull long dateBegin, @NonNull long dateEnd) {
            this.title = title;
            this.location = location;
            this.dateBegin = dateBegin;
            this.dateEnd = dateEnd;
        }
        public int getId() {return id;}
        public String getLocation() {
            return location;
        }
        public String getTitle() {
            return title;
        }
        public long getDateBegin() {
            return dateBegin;
        }
        public long getDateEnd() {
            return dateEnd;
        }
        public Event toEvent(){
            Calendar date1 = Calendar.getInstance();
            date1.setTimeInMillis(dateBegin);

            Calendar date2 = Calendar.getInstance();
            date2.setTimeInMillis(dateEnd);

            return new Event(this.title,this.location,date1,date2);
        }

        public void setId(int id) {
        this.id = id;
    }

    }
