package com.example.project_trpp.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.netwoevents.R;
import com.example.netwoevents.ui.viewmodel.ContactViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ShowItemContactFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = (ImageView) getView().findViewById(R.id.contact_image);
        TextView textView = (TextView) getView().findViewById(R.id.contact_text);
        EditText editText = (EditText) getView().findViewById(R.id.send_message);

        FloatingActionButton btnMsg = (FloatingActionButton) getView().findViewById(R.id.btn_send_message);
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(editText.VISIBLE);
                if(getArguments() != null) {
                    String sharedText = (String) getArguments().getString("bundleSharedText");
                    editText.setText(sharedText);

                }
            }
        });




        ContactViewModel contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        contactViewModel.getResultLiveName().observe(getViewLifecycleOwner(),resultLiveName ->{

            textView.setText((String) resultLiveName);

        });

        contactViewModel.getResultLiveImage().observe(getViewLifecycleOwner(),resultLiveImage ->{

            imageView.setImageResource((int)resultLiveImage);

        });

      contactViewModel.getDataFromContactList(getArguments());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_show_item_contact, container, false);
    }
}