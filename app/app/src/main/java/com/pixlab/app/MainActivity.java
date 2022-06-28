package com.pixlab.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;
    private ConstraintLayout windowCreateCanvas;
    private Button createButton;
    private Button windowCloseButton;
    private Button size32;
    private Button size64;
    private Button size128;
    private EditText inputWidth;
    private EditText inputHeight;
    private Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        windowCreateCanvas = findViewById(R.id.windowCreateCanvas);
        createButton = findViewById(R.id.createButton);
        windowCloseButton = findViewById(R.id.windowCloseButton);
        size32 = findViewById(R.id.size32);
        size64 = findViewById(R.id.size64);
        size128 = findViewById(R.id.size128);
        inputWidth = findViewById(R.id.inputWidth);
        inputHeight = findViewById(R.id.inputHeight);
        openButton = findViewById(R.id.openButton);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate().rotationBy(360);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowCreateCanvas.setVisibility(View.VISIBLE);
            }
        });

        windowCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowCreateCanvas.setVisibility(View.INVISIBLE);
            }
        });

        size32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWidth.setText("32");
                inputHeight.setText("32");
            }
        });

        size64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWidth.setText("64");
                inputHeight.setText("64");
            }
        });

        size128.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWidth.setText("128");
                inputHeight.setText("128");
            }
        });

        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainCanvas = new Intent(MainActivity.this, MainCanvas.class);
                startActivity(mainCanvas);
            }
        });
    }
}