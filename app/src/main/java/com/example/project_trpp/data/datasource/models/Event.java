package com.example.project_trpp.data.datasource.models;


import java.io.Serializable;
import java.util.Calendar;


public class Event implements Serializable {

        private String title;
        private String location;
        private Calendar dateBegin;
        private Calendar dateEnd;

        public Event(String title, String location, Calendar dateBegin, Calendar dateEnd) {
            this.title = title;
            this.location = location;
            this.dateBegin = dateBegin;
            this.dateEnd = dateEnd;

        }

        public String getTitle() {
            return title;
        }

        public String getEvent() {
            return title;
        }


        public Calendar getDateBegin() {
            return dateBegin;
        }

        public Calendar getDateEnd() {
            return dateEnd;
        }

        public String getLocation() {
            return location;
        }
    }







