package com.example.netwoevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class LoginFragment extends Fragment {

    private Button btnEvent;
    private Button btnContact;


    private Button btn1;
    private EditText email;
    private EditText password;

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        btnContact = (Button) getView().findViewById(R.id.button_contact_list);
        btnEvent = (Button) getView().findViewById(R.id.button_event_list);




        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_contactListFtagment);

//                ContactListFtagment contactListFtagment = new ContactListFtagment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().
//                        setReorderingAllowed(true);
//                ft.replace(R.id.frame_layout, contactListFtagment);
//                ft.addToBackStack(null);
//                ft.commit();
            }
        });

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_eventRecyclerFragment);


//                EventRecyclerFragment eventRecyclerFragment = new EventRecyclerFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().
//                        setReorderingAllowed(true);
//                ft.replace(R.id.frame_layout, eventRecyclerFragment);
//                ft.addToBackStack(null);
//                ft.commit();
            }
        });


        btn1 =  (Button) getView().findViewById(R.id.button_home);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment2);


//                HomeFragment homeFragment = new HomeFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().
//                        setReorderingAllowed(true);
//                ft.replace(R.id.frame_layout, homeFragment);
//                ft.addToBackStack(null);
//                ft.commit();

               email = (EditText) getView().findViewById(R.id.et1);
               password = (EditText) getView().findViewById(R.id.et2);

               String em = email.getText().toString();
               String ps = password.getText().toString();


                    Bundle bundle = new Bundle();
                    bundle.putString("bundleKey", em);
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment2, bundle);

//                    Bundle result = new Bundle();
//                    result.putString("bundleKey", em);
//                    getParentFragmentManager().setFragmentResult(
//                            "requestKey", result);



            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_login, container, false);
    }



//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        Log.d(F2,"onAttach" );
//        Toast.makeText(getActivity(),
//                "onAttach",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        Log.d(F2,"onCreate" );
//        Toast.makeText(getActivity(),
//                "onCreate",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//
//        Log.d(F2,"onViewStateRestored" );
//        Toast.makeText(getActivity(),
//                "onViewStateRestored",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        Log.d(F2,"onStart" );
//        Toast.makeText(getActivity(),
//                " onStart",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        Log.d(F2,"onResume" );
//        Toast.makeText(getActivity(),
//                "onResume",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//
//        Log.d(F2,"onPause" );
//        Toast.makeText(getActivity(),
//                "onPause",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        Log.d(F2,"onStop" );
//        Toast.makeText(getActivity(),
//                "onStop",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        Log.d(F2,"onSaveInstanceState" );
//        Toast.makeText(getActivity(),
//                "onSaveInstanceStated",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//
//        Log.d(F2,"onDestroyView" );
//        Toast.makeText(getActivity(),
//                "onDestroyView",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//
//        Log.d(F2,"onDestroy" );
//        Toast.makeText(getActivity(),
//                "onDestroy",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//
//        Log.d(F2,"onDetach" );
//        Toast.makeText(getActivity(),
//                "onDetach",
//                Toast.LENGTH_LONG).show();
//    }
}