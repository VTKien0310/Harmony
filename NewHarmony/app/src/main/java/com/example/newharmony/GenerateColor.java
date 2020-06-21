package com.example.newharmony;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GenerateColor extends AppCompatActivity {
    ImageView colorWheel;
    Bitmap bitmap;
    Scheme colorScheme;
    int[] lockedColors = {0, 0, 0, 0, 0, 0};

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_color);

        colorScheme = new Scheme();


        Intent intent = getIntent();
        if(intent.hasExtra("h"))
        {
            float h = intent.getExtras().getFloat("h"),
                    s = intent.getExtras().getFloat("s"),
                    l = intent.getExtras().getFloat("l");
            colorScheme.setColorAtPos(0, new float[]{h, s, l});
            setLocked(findViewById(R.id.color0));
            colorScheme.generateColors(lockedColors);
        }
        setScheme();

        colorWheel = findViewById(R.id.colorWheel);
        colorWheel.setDrawingCacheEnabled(true);
        colorWheel.buildDrawingCache(true);

        // on click event for color picker
        colorWheel.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == MotionEvent.ACTION_DOWN)
                        || (event.getAction() == MotionEvent.ACTION_MOVE)) {
                    bitmap = colorWheel.getDrawingCache();
                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);
                    float[] hsl = {0, 0, 0};

                    // set the picked color onto the first color of color scheme
                    // then display it onto view
                    ColorUtils.RGBToHSL(r, g, b, hsl);
                    colorScheme.setColorAtPos(0, hsl);
                    TextView color0 = findViewById(R.id.color0);
                    setColors(color0, 0);
                }
                return true;
            }
        });
    }

    // start the colors generating process
    public void generate(View view) {
        colorScheme.generateColors(lockedColors);
        setScheme();
    }

    // set the color scheme to view
    public void setScheme() {
        int[] colorViewIds = new int[]{R.id.color0, R.id.color1, R.id.color2,
                R.id.color3, R.id.color4, R.id.color5};

        for (int i = 0; i < 6; i++) {
            int currId = colorViewIds[i];
            TextView currColorView = findViewById(currId);
            setColors(currColorView, i);
        }
    }

    // set a color in the color scheme to view
    public void setColors(TextView view, int pos) {
        float[] hsl = colorScheme.getColorAtPos(pos);
        int color = ColorUtils.HSLToColor(hsl);

        view.setBackgroundColor(color);

        // display hex value info
        String hexValue = "#" + Integer.toHexString(color);
        view.setText(hexValue);
        if (hsl[2] >= 0.8)
            view.setTextColor(Color.parseColor("#000000"));
        else
            view.setTextColor(Color.parseColor("#FFFFFF"));
    }

    // note the colors that the user want to keep
    public void setLocked(View view) {
        TextView lockedColor = (TextView) view;
        int viewId = lockedColor.getId();

        // note the locked color position and change the indicating icon
        switch (viewId) {
            case R.id.color0:
                if (lockedColors[0] == 0) {
                    lockedColors[0] = 1;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, 0, 0);
                } else {
                    lockedColors[0] = 0;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unlock, 0, 0, 0);
                }
                break;
            case R.id.color1:
                if (lockedColors[1] == 0) {
                    lockedColors[1] = 1;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, 0, 0);
                } else {
                    lockedColors[1] = 0;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unlock, 0, 0, 0);
                }
                break;
            case R.id.color2:
                if (lockedColors[2] == 0) {
                    lockedColors[2] = 1;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, 0, 0);
                } else {
                    lockedColors[2] = 0;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unlock, 0, 0, 0);
                }
                break;
            case R.id.color3:
                if (lockedColors[3] == 0) {
                    lockedColors[3] = 1;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, 0, 0);
                } else {
                    lockedColors[3] = 0;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unlock, 0, 0, 0);
                }
                break;
            case R.id.color4:
                if (lockedColors[4] == 0) {
                    lockedColors[4] = 1;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, 0, 0);
                } else {
                    lockedColors[4] = 0;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unlock, 0, 0, 0);
                }
                break;
            case R.id.color5:
                if (lockedColors[5] == 0) {
                    lockedColors[5] = 1;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lock, 0, 0, 0);
                } else {
                    lockedColors[5] = 0;
                    lockedColor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unlock, 0, 0, 0);
                }
                break;
            default:
                break;
        }
    }
}