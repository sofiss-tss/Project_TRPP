package com.example.project_trpp.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.netwoevents.R;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       btn1 = findViewById(R.id.button1);

       NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
               .findFragmentById(R.id.fragmentContainerView);
       NavController navController = navHostFragment.getNavController();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_homeFragment_to_loginFragment);

            }
        });

       Intent intent = getIntent();
       if (intent != null && intent.getAction() != null && intent.getAction().
               equals(Intent.ACTION_SEND)) {
           String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);

           if (sharedText != null) {
                //создаем новый фрагмент и передаем полученные данные
               Bundle args = new Bundle();
               args.putString("sharedText", sharedText);
               navController.navigate(R.id.action_homeFragment_to_contactListFtagment, args);

           }
       }
    }

}



