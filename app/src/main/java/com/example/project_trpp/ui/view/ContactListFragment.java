package com.example.project_trpp.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.Item;
import com.example.netwoevents.data.repository.ContactRepository;
import com.example.netwoevents.domain.usecase.GetContactListUseCase;
import com.example.netwoevents.ui.adapter.MyCustomListAdapter;

import java.util.ArrayList;

public class ContactListFragment extends Fragment {
    private ListView listView;
    String sharedText;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ContactRepository contactRepository = new ContactRepository(getContext());
        GetContactListUseCase getContactListUseCase = new GetContactListUseCase(contactRepository);
        ArrayList<Item> items = getContactListUseCase.execute();

        listView = (ListView) getView().findViewById(R.id.contact_list);
        MyCustomListAdapter adapter = new MyCustomListAdapter(getContext(),
                R.layout.list_view_layout_contact, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Bundle bundle = new Bundle();
                bundle.putString("bundleText", items.get(position).getText());
                bundle.putInt("bundleImage", items.get(position).getImage());
                bundle.putString("bundleSharedText", sharedText);
                Navigation.findNavController(view).navigate(
                        R.id.action_contactListFtagment_to_showItemContactFragment, bundle);

                TextView textView = (TextView)v.findViewById(R.id.item_text);
                String value = (String) textView .getText();
                Toast.makeText(getActivity(),
                        "Здравствуйте, " + value +"!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null) {
            sharedText = (String) getArguments().getString("sharedText");
            Toast.makeText(getContext(), sharedText, Toast.LENGTH_SHORT).show();

        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }
}