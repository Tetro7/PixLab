package com.pixlab.app;

import android.graphics.Color;
import android.widget.LinearLayout;

public class Pencil implements Tool {
    @Override
    public void Action(LinearLayout containerCanvas, int width, int height, int x, int y, int arrayPixels[][], int color)
    {
        int widthPixel = containerCanvas.getWidth() / width;
        int heightPixel = containerCanvas.getHeight() / height;

        int left = 0, top = 0;

        for (int i = 0; i < containerCanvas.getWidth(); i++)
        {
            if (x >= i && x <= i + widthPixel)
            {
                left = i / widthPixel;
            }
        }

        for (int i = 0; i < containerCanvas.getHeight(); i += heightPixel)
        {
            if (y >= i && y <= i + heightPixel)
            {
                top = i / heightPixel;
            }
        }

        arrayPixels[top][left] = Color.RED;
    }
}
