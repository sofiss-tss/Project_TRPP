package com.example.project_trpp.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class NewEventFragment extends Fragment {

    public Calendar FromStringToCalendar(String dateString){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editTextTitle = (EditText) getView().findViewById(R.id.edit_text_new_event);
        EditText editTextDateBegin = (EditText)getView().findViewById(R.id.et_data_begin);
        EditText editTextDateEnd = (EditText)getView().findViewById(R.id.et_data_end);
        EditText editTextLoc = (EditText)getView().findViewById(R.id.et_location);
        Button btnSave = (Button) getView().findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String newEvent = editTextTitle.getText().toString();
                String dateBegin = editTextDateBegin.getText().toString();
                String dateEnd = editTextDateEnd.getText().toString();
                String location = editTextLoc.getText().toString();

                Bundle bundle = new Bundle();
                if(newEvent.isEmpty())
                {
                    Toast.makeText(getContext(), "Ввведите название", Toast.LENGTH_SHORT).show();
                }
                else {



                    Event event = new Event(newEvent, location,FromStringToCalendar(dateBegin),
                            FromStringToCalendar(dateEnd));
                    bundle.putSerializable("bundleKey",event);

//                    bundle.putString("bundleKey", newEvent);
//                    bundle.putString("bundleKey_date1", dateBegin);
//                    bundle.putString("bundleKey_date2", dateEnd);
//                    bundle.putString("bundleKey_location", location);
                    Navigation.findNavController(view).navigate
                            (R.id.action_newEventFragment_to_eventRecyclerFragment, bundle);
                }
            }
        });
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_new_event, container, false);
    }

}