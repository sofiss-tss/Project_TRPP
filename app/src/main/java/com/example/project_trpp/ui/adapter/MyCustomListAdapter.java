package com.example.project_trpp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.Item;

import java.util.List;

    public class MyCustomListAdapter extends ArrayAdapter<Item> {
        private LayoutInflater inflater;
        private int layout;
        private List<Item> items;
        public MyCustomListAdapter(Context context, int resource,
                                   List<Item> items) {
            super(context, resource, items);
            this.items = items;
            this.layout = resource;
            this.inflater = LayoutInflater.from(context);
        }
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            View view = inflater.inflate(this.layout, parent, false);
            TextView textView = view.findViewById(R.id.item_text);
            ImageView imageView = view.findViewById(R.id.item_image);
            Item item = items.get(position);
            textView.setText(item.getText());
            imageView.setImageResource((item.getImage()));
            return view;
        }
    }


