package com.example.project_trpp.ui.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.Event;

public class EventViewHolder extends RecyclerView.ViewHolder{
    private final TextView eventItemView;
    private Event event;

    private EventViewHolder(View itemView) {
        super(itemView);
        eventItemView = itemView.findViewById(R.id.item_event);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("bundleKey", event);
                //bundle.putString("bundleText", (String) eventItemView.getText());
                Navigation.findNavController(itemView).navigate(R.id.action_eventRecyclerFragment_to_showItemEventFragment, bundle);

            }
        });

    }

    public void bind(Event event) {
        this.event = event;
        eventItemView.setText(event.getTitle());
    }

    static EventViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_layot_event, parent, false);

        return new EventViewHolder(view);
    }
}
