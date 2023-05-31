package com.example.project_trpp.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShowItemEventFragment extends Fragment {
    private Event event;

    public String fromCalendarToString(Calendar calendar){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String dateString = format.format(calendar.getTime());
        return dateString;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView titleView = (TextView) getView().findViewById(R.id.event_text);
        TextView dateView = (TextView) getView().findViewById(R.id.show_date);
        TextView locView = (TextView) getView().findViewById(R.id.show_location);

        if (getArguments() != null) {
            event = (Event) getArguments().getSerializable("bundleKey");
            titleView.setText(event.getTitle());
            dateView.setText(fromCalendarToString(event.getDateBegin())+" - "+
                    fromCalendarToString(event.getDateEnd()) );
            locView.setText(event.getLocation());
        }

        FloatingActionButton btnAddCalendar = (FloatingActionButton) getView().findViewById(R.id.btn_calendar);
        btnAddCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Создание Intent для создания событие в календаре
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT,
                        CalendarContract.Events.CONTENT_URI);

                Calendar beginTime = event.getDateBegin();
                Calendar endTime = event.getDateEnd();

                //Добавление данных в Intent
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        beginTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.Events.TITLE, event.getTitle());
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, event.getLocation());

                //Запуск Intent
                startActivity(Intent.createChooser(calendarIntent, "Поделиться с помощью"));
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_item_event, container, false);
    }
}