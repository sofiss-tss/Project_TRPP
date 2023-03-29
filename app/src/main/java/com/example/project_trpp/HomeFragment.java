package com.example.project_trpp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 *  Фрагмент, отображающий главный экран приложения
 */
public class HomeFragment extends Fragment {
    private ImageView picture; // изображение на главном экране
    private ImageView question; // изображение иконки вопроса
    private EditText email; // поле для ввода адреса электронной почты
    private EditText message; // поле для ввода сообщения
    private Button btn2; // кнопка для отправки сообщения
    private TextView txt; // текстовое поле для отображения статуса отправки сообщения

    private String value; // значение для передачи через Bundle
    private static final String TAG = "MyTAG"; // тег для логирования
    private static final String F1 = "Fragment_1"; // название фрагмента

    /**

     Проверка правильности введенного адреса электронной почты.
     @param email адрес электронной почты для проверки
     @return true, если адрес электронной почты корректен, иначе false
     */

    public boolean isEmailValid (String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**

     Создание и возвращение представления, отображающего главный экран приложения.

     @param inflater объект, отвечающий за разбор макета и создание объектов View

     @param container родительский View, в котором будет размещен фрагмент

     @param savedInstanceState сохраненное состояние фрагмента

     @return представление, отображающее главный экран приложения
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    /**

     Создание View-компонентов и обработчиков событий для элементов на главном экране.

     @param view представление, отображающее главный экран приложения

     @param savedInstanceState сохраненное состояние фрагмента
     */

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // получение ссылок на View-компоненты
        picture = (ImageView) getView().findViewById(R.id.picture);
        picture.setImageResource(R.drawable.p2);
        txt =  (TextView) getView().findViewById(R.id.txtt);
        question = (ImageView) getView().findViewById(R.id.question);

        email = (EditText) getView().findViewById(R.id.email);
        message = (EditText) getView().findViewById(R.id.messages);
        btn2 =  (Button) getView().findViewById(R.id.button2);

        // проверка наличия переданных данных через Bundle
        if (getArguments() != null) {
            value = getArguments().getString("bundleKey");
            Log.e(TAG,value);
            email.setText(value);
        }

        /**

         Обработчик нажатия на кнопку "Продолжить". Проверяет введенный адрес электронной почты и сообщение.

         Если адрес электронной почты неверный, то выводится сообщение об ошибке.

         Если сообщение пустое, то выводится предупреждение.

         Если все данные заполнены корректно, то выводится сообщение об успешной отправке и отключаются поля ввода.
         @param view View, на которую нажали
         */

         btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG,"Нажата клавиша продолжить");
                        String em = String.valueOf(email.getText());
                        String ms = String.valueOf(message.getText());
                        if (!isEmailValid(em)) {
                            Toast.makeText(getActivity(),
                                    "Проверьте адрес электронной почты",
                                    Toast.LENGTH_LONG).show();
                            Log.e(TAG,"Неверный адрес электронной почты");
                        }
                        else if (ms.isEmpty()) {

                            Toast.makeText(getActivity(),
                                    "Введите сообщение", Toast.LENGTH_LONG).show();
                            Log.w(TAG,"Пустое сообщение");
                        }
                        else {
                            Toast.makeText(getActivity(),
                                    "Сообщение получено! Ожидайте ответа на почте",
                                    Toast.LENGTH_LONG).show();
                            txt.setText("Cообщение отправлено");
                            Log.i(TAG,"Сообщение отправлено");
                            question.setImageResource(R.drawable.check);
                            email.setEnabled(false);
                            message.setEnabled(false);
                        }
                    }
                }
        );

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




//        getParentFragmentManager().setFragmentResultListener("requestKey",
//                this, new FragmentResultListener() {
//                    public void onFragmentResult(@NonNull String requestKey,
//                                                 @NonNull Bundle bundle) {
//
//                        String result = bundle.getString("bundleKey");
//                        email.setText(result);
//                    }
//                });


    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        Log.d(F1,"onAttach" );
//        Toast.makeText(getActivity(),
//                "onAttach",
//                Toast.LENGTH_LONG).show();
//    }
//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//
//        Log.d(F1,"onViewStateRestored" );
//        Toast.makeText(getActivity(),
//                "onViewStateRestored",
//                Toast.LENGTH_LONG).show();
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        Log.d(F1,"onStart" );
//        Toast.makeText(getActivity(),
//                " onStart",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        Log.d(F1,"onResume" );
//        Toast.makeText(getActivity(),
//                "onResume",
//                Toast.LENGTH_LONG).show();
//    }
//    @Override
//    public void onPause() {
//        super.onPause();
//
//        Log.d(F1,"onPause" );
//        Toast.makeText(getActivity(),
//                "onPause",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        Log.d(F1,"onStop" );
//        Toast.makeText(getActivity(),
//                "onStop",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        Log.d(F1,"onSaveInstanceState" );
//        Toast.makeText(getActivity(),
//                "onSaveInstanceStated",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//
//        Log.d(F1,"onDestroyView" );
//        Toast.makeText(getActivity(),
//                "onDestroyView",
//                Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//
//        Log.d(F1,"onDestroy" );
//        Toast.makeText(getActivity(),
//                "onDestroy",
//                Toast.LENGTH_LONG).show();
//    }
//    @Override
//    public void onDetach() {
//        super.onDetach();
//
//        Log.d(F1,"onDetach" );
//        Toast.makeText(getActivity(),
//                "onDetach",
//                Toast.LENGTH_LONG).show();
//    }

}
