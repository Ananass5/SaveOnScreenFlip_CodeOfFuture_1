package com.ananas.first_codeoffuture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String COUNT_KEY = "0";
    private int counter = 0;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView2);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener);

    }

    View.OnTouchListener listener1 = (view, MotionEvent) -> {
        return true;
    };

    View.OnClickListener listener = view -> {
        counter++;
        textView.setText(Integer.toString(counter));
        if (counter % 100 == 0) Toast.makeText(this, "Юхууу!", Toast.LENGTH_SHORT).show();
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_KEY, counter);
       // Toast.makeText(this, "Положили в Bundle", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt(COUNT_KEY);
        textView.setText(Integer.toString(savedInstanceState.getInt(COUNT_KEY)));
    }


}