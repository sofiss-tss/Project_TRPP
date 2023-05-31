package com.example.project_trpp.ui.view;





import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.Event;
import com.example.netwoevents.ui.adapter.EventListAdapter;
import com.example.netwoevents.ui.viewmodel.EventViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class EventRecyclerFragment extends Fragment {


    private EventViewModel eventViewModel;


    public Event getEvent() {
        return event;
    }

    Event event;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        FloatingActionButton btnAddEvent = (FloatingActionButton) getView().findViewById(R.id.btn_add);
        btnAddEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_eventRecyclerFragment_to_newEventFragment);

            }
        });

        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.event_recycler_list);;
        final EventListAdapter adapter = new EventListAdapter(new EventListAdapter.EventDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);

        eventViewModel.getAllEvents().observe(getViewLifecycleOwner(), events -> {


            adapter.submitList(events);
        });

        if (event!= null){
            eventViewModel.insert(event);
            event = null;
        }














//        EventRepository eventRepository = new EventRepository(getContext());
//        GetEventListUseCase getEventListUseCase = new GetEventListUseCase(eventRepository);
//
//        ArrayList<Item> items = getEventListUseCase.execute();
//        listView = (RecyclerView) getView().findViewById(R.id.event_recycler_list);
//
//        MyCustomRecyclerViewAdapter adapter = new MyCustomRecyclerViewAdapter(getContext(), items);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        listView.setLayoutManager(layoutManager);
//        listView.setAdapter(adapter);

}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()!= null) {
            event = (Event) getArguments().getSerializable("bundleKey");

        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_event_recycler, container, false);
    }



}