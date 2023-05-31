package com.example.netwoevents;


import static android.app.PendingIntent.getActivity;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.netwoevents.R;
import com.example.netwoevents.ui.view.MainActivity;

public class EventService extends Service {

    private WindowManager windowManager;
    private View bannerView;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Создаем баннер
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        bannerView = inflater.inflate(R.layout.service_layout, null);

        // Создаем WindowManager
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        // Определяем параметры для размещения баннера
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        // Устанавливаем позицию баннера
        params.gravity = Gravity.CENTER| Gravity.BOTTOM ;

        //Запрос разрешения для Android 6.0 (API 23) и выше
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            // Открываем экран настроек управления разрешениями на отображение наложений
            Intent intent2 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            //Устанавливаем флаг для запуска в новом стеке задач
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent2);
        } else {
            // Если разрешение доступно, то отображаем баннер
            windowManager.addView(bannerView, params);
        }

        // Создаем PendingIntent для перехода в запущенное приложение
        Intent appIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = getActivity(this, 0, appIntent, 0);

        // Добавляем возможность перехода в запущенное приложение при клике на баннер
        bannerView.setOnClickListener(view -> {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        });

        // Настройка кнопки закрытия всплывающего окна
        ImageButton closeButton = bannerView.findViewById(R.id.button_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Закрытие сервиса при нажатии на кнопку
                stopSelf();
            }
        });

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Удаляем баннер с экрана при завершении сервиса
        if (bannerView != null && bannerView != null) {
            windowManager.removeView(bannerView);
        }
    }
}