package com.pixlab.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate().rotation(360);
            }
        });
    }
}