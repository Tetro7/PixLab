package com.pixlab.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

class DrawViewBackground extends View {
    private int width;
    private int height;
    private LinearLayout containerCanvas;
    private Paint paint;
    private float x;
    private float y;

    public DrawViewBackground(Context context, int width, int height, LinearLayout containerCanvas) {
        super(context);

        this.width = width;
        this.height = height;
        this.containerCanvas = containerCanvas;

        this.paint = new Paint();
        this.paint.setColor(Color.BLACK);
        this.paint.setStyle(Paint.Style.FILL);

        this.x = 0;
        this.y = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int widthPixel = containerCanvas.getWidth() / width;
        int heightPixel = containerCanvas.getHeight() / height;

        for (int i = 0; i < containerCanvas.getHeight(); i += heightPixel)
        {
            for (int j = 0; j < containerCanvas.getWidth(); j += widthPixel)
            {
                if ((i / heightPixel) % 2 == 0)
                {
                    if ((j / widthPixel) % 2 == 0)
                    {
                        paint.setColor(Color.rgb(149, 151, 154));
                    }
                    else
                    {
                        paint.setColor(Color.rgb(229, 231, 233));
                    }
                }
                else
                {
                    if ((j / widthPixel) % 2 == 0)
                    {
                        paint.setColor(Color.rgb(229, 231, 233));
                    }
                    else
                    {
                        paint.setColor(Color.rgb(149, 151, 154));
                    }
                }

                canvas.drawRect(j, i, j + widthPixel, i + heightPixel, paint);
            }
        }

    }

    public void drawPixel(Canvas canvas, float x, float y)
    {
        paint.setColor(Color.RED);

        int widthPixel = containerCanvas.getWidth() / width;
        int heightPixel = containerCanvas.getHeight() / height;

        int left = 0, top = 0, right = 0, bottom = 0;

        for (int i = 0; i < containerCanvas.getWidth(); i += widthPixel)
        {
            if (x >= i && x <= i + widthPixel)
            {
                left = i;
                right = i + widthPixel;
            }
        }

        for (int i = 0; i < containerCanvas.getHeight(); i += heightPixel)
        {
            if (y >= i && y <= i + heightPixel)
            {
                top = i;
                bottom = i + heightPixel;
            }
        }

        canvas.drawRect(left, top, right, bottom, paint);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        x = event.getX();
        y = event.getY();

        invalidate();

        return true;
    }
}