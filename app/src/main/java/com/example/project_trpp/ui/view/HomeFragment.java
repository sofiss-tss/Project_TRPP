package com.example.project_trpp.ui.view;


import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.netwoevents.EventService;
import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.Message;
import com.example.netwoevents.ui.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {
    private ImageView picture;
    private ImageView question;
    private EditText email;
    private EditText message;
    private Button btn2;
    private ImageButton btnMsg;
    private TextView txt;

    private String value;
    String toastText;
    private static final String TAG = "MyTAG";
    private final String CHANNEL_ID="channel_id";
    private static final int NOTIFICATION_ID = 1;


    public void sendNotification (Message msg){
        // Есть ли разрешения на отправку уведомления
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.
                POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // Если разрешение не получено, запрашиваем его у пользователя
            ActivityCompat.requestPermissions((Activity)getContext(),new String[]{
                    Manifest.permission.POST_NOTIFICATIONS}, 1);
        }

        //Реакция на уведомления
        Intent notificationIntent = new Intent(getContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(),
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        // Создаем канал уведомлений (для Android 8.0 (API 26) и выше.)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "name_channel";
            String description = "description_channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getContext().
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Создаем уведомление
        String text = "Ваше сообщение получено!\nОжидайте ответа на почте " + msg.getEmail();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(),
                CHANNEL_ID)
                .setSmallIcon(R.drawable.check)
                .setContentTitle("Уведомление от NetwoEvents")
                .setContentIntent(pendingIntent)
                .setContentText("Ваше сообщение получено!")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLargeIcon(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ne1))
                .setAutoCancel(true); // автоматически закрыть уведомление после нажатия

        // Отправляем уведомление
        NotificationManagerCompat notificationManager = NotificationManagerCompat
                .from(getContext());
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        picture = (ImageView) getView().findViewById(R.id.picture);
        picture.setImageResource(R.drawable.p2);
        txt =  (TextView) getView().findViewById(R.id.txtt);
        question = (ImageView) getView().findViewById(R.id.question);
        email = (EditText) getView().findViewById(R.id.email);
        message = (EditText) getView().findViewById(R.id.messages);
        btn2 =  (Button) getView().findViewById(R.id.button2);
        btnMsg = (ImageButton) getView().findViewById(R.id.button_msg);

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EventService.class);
                getActivity().startService(intent);
            }
        });

        if (getArguments() != null) {
            value = getArguments().getString("bundleKey");
            email.setText(value);
        }


        String em = String.valueOf(email.getText());
        String ms = String.valueOf(message.getText());

        Message msg = new Message(em, ms);

        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getResultLive().observe(getViewLifecycleOwner(),resultLive ->{
            toastText = (String) resultLive;

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeViewModel.checkMessage(msg);
                Toast.makeText(getContext(),toastText, Toast.LENGTH_SHORT).show();


               if(homeViewModel.getCorrectData()) {
                   homeViewModel.sendMessage(msg);
                   txt.setText("Cообщение отправлено");
                   question.setImageResource(R.drawable.check);
                   email.setEnabled(false);
                   message.setEnabled(false);
                   sendNotification(msg);
               }


            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
