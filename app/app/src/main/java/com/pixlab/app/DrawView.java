package com.pixlab.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

class DrawView extends View {
    private int width;
    private int height;
    private LinearLayout containerCanvas;
    private Paint paint;
    private int arrayPixels[][];
    public Tool tool;

    public DrawView(Context context, int width, int height, LinearLayout containerCanvas) {
        super(context);

        this.width = width;
        this.height = height;
        this.containerCanvas = containerCanvas;

        this.paint = new Paint();
        this.paint.setColor(Color.BLACK);
        this.paint.setStyle(Paint.Style.FILL);

        tool = new Pencil();

        arrayPixels = new int[height][width];

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                arrayPixels[i][j] = Color.TRANSPARENT;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int widthPixel = containerCanvas.getWidth() / width;
        int heightPixel = containerCanvas.getHeight() / height;

        for (int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                paint.setColor(arrayPixels[i][j]);
                canvas.drawRect(j * widthPixel, i * heightPixel, (j + 1) * widthPixel, (i + 1) * heightPixel, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int x = (int)event.getX();
        int y = (int)event.getY();

        tool.Action(containerCanvas, width, height, x, y, arrayPixels);
        invalidate();

        return true;
    }

    public void setPaintColor(int color)
    {
        paint.setColor(color);
    }
}
