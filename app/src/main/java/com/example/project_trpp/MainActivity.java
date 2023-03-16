package com.example.project_trpp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

    public void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().
                setReorderingAllowed(true);
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        //setNewFragment(new HomeFragment());


       NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
               .findFragmentById(R.id.fragmentContainerView);
       NavController navController = navHostFragment.getNavController();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // navController.navigate(R.id.action_homeFragment_to_loginFragment);

            }
        });
    }

}







//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.netwoevents.databinding.ActivityMainBinding;
//
//public class MainActivity extends AppCompatActivity {
//    private static final String TAG = "MyTAG";
//    private ActivityMainBinding binding;
//    public boolean isEmailValid(String email) {
//        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
//    }
//
//    public void startLogin(View v) {
//        Intent intent = new Intent(this,Login.class);
//        startActivity(intent);
//        Log.i(TAG,"Нажата клавиша Войти");
//    }
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        binding.picture.setImageResource(R.drawable.p2);
//
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        View viewRoot = binding.getRoot();
//        setContentView(viewRoot);
//
//        binding.button2.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Log.i(TAG,"Нажата клавиша продолжить");
//                        String ms = null;
//                        String em = String.valueOf((binding.email).getText());
//                        System.out.println(em);
//                        ms = String.valueOf((binding.messages).getText());
//                        if (!isEmailValid(em)) {
//                            Toast.makeText(MainActivity.this,
//                                    "Проверьте адрес электронной почты", Toast.LENGTH_LONG).show();
//                            Log.e(TAG,"Неверный адрес электронной почты");
//                        } else if (ms.isEmpty()) {
//
//                            Toast.makeText(MainActivity.this,
//                                    "Введите сообщение", Toast.LENGTH_LONG).show();
//                            Log.w(TAG,"Пустое сообщение");
//                        } else {
//                            Toast.makeText(MainActivity.this,
//                                    "Сообщение получено! Ожидайте ответа на почте", Toast.LENGTH_LONG).show();
//                            binding.txtt.setText("Cообщение отправлено");
//                            binding.question.setImageResource(R.drawable.check);
//                            binding.email.setEnabled(false);
//                            binding.messages.setEnabled(false);
//                            Log.i(TAG,"Сообщение отправлено");
//                        }
//
//                    }
//                }
//        );
//    }
//
//
//
//}

