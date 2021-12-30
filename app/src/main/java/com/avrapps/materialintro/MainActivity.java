package com.avrapps.materialintro;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.avrapps.materialintro.R;

public class MainActivity extends AppCompatActivity {
    AppCompatButton button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_launch_activity);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(intent);
        });
    }
}
