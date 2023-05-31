package com.example.project_trpp.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.netwoevents.data.datasource.models.Event;

public class EventListAdapter extends ListAdapter<Event, EventViewHolder> {


    public EventListAdapter(@NonNull DiffUtil.ItemCallback<Event> diffCallback) {
        super(diffCallback);

    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return EventViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event current = getItem(position);
        holder.bind(current);
    }

    static public class EventDiff extends DiffUtil.ItemCallback<Event> {

        @Override
        public boolean areItemsTheSame(@NonNull Event oldItem, @NonNull Event newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Event oldItem, @NonNull Event newItem) {
            return oldItem.getEvent().equals(newItem.getEvent());
        }
    }
}