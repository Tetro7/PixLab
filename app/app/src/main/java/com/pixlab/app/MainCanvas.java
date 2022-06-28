package com.pixlab.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainCanvas extends AppCompatActivity {

    private LinearLayout containerCanvas;
    private LinearLayout containerCanvasBackground;
    private ImageButton toolPan;
    private ImageButton toolRubber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_canvas);

        containerCanvas = findViewById(R.id.containerCanvas);
        containerCanvasBackground = findViewById(R.id.containerCanvasBackground);
        toolPan = findViewById(R.id.toolPan);
        toolRubber = findViewById(R.id.toolRubber);

        DrawViewBackground drawViewBackground = new DrawViewBackground(this, 16, 16, containerCanvasBackground);
        containerCanvasBackground.addView(drawViewBackground);
        DrawView drawView = new DrawView(this, 16, 16, containerCanvas);
        containerCanvas.addView(drawView);

        toolPan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.tool = new Pencil();
            }
        });

        toolRubber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.tool = new Rubber();
            }
        });
    }
}