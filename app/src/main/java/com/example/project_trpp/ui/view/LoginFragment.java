package com.example.project_trpp.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.UserData;
import com.example.netwoevents.ui.viewmodel.LoginViewModel;
import com.example.netwoevents.ui.viewmodel.LoginViewModelFactory;


public class LoginFragment extends Fragment {

    private Button btnEvent;
    private Button btnContact;

    private  Button btnLogin;
    private Button btnHome;
    private EditText email;
    private EditText password;
    String em;
    String ps;

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        btnContact = (Button) getView().findViewById(R.id.button_contact_list);
        btnEvent = (Button) getView().findViewById(R.id.button_event_list);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(
                        R.id.action_loginFragment_to_eventRecyclerFragment);

            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_loginFragment_to_contactListFtagment);
            }
        });

        email = (EditText) getView().findViewById(R.id.et1);
        password = (EditText) getView().findViewById(R.id.et2);
        btnLogin = btnHome =  (Button) getView().findViewById(R.id.button_login);

        LoginViewModel loginViewModel = new ViewModelProvider(this,
                new LoginViewModelFactory(getContext())).get(LoginViewModel.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                em = email.getText().toString();
                ps = password.getText().toString();
                UserData userData = new UserData(em, ps);

                loginViewModel.saveUserData(userData);

            }
        });

        btnHome =  (Button) getView().findViewById(R.id.button_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Bundle bundle = new Bundle();
              bundle.putString("bundleKey", em);
              Navigation.findNavController(view).navigate
                      (R.id.action_loginFragment_to_homeFragment2, bundle);
           }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_login, container, false);
    }

}