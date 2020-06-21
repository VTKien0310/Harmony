package com.example.newharmony;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLAS_SCREEN = 3000;

    Animation top, bot;
    ImageView im;
    TextView tx1, tx2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        top = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bot = AnimationUtils.loadAnimation(this,R.anim.bot_animation);

        im = findViewById(R.id.imageView);
        tx1 = findViewById(R.id.textView);
        tx2 = findViewById(R.id.textView2);

        im.setAnimation(bot);
        tx1.setAnimation(bot);
        tx2.setAnimation(top);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mh = new Intent(MainActivity.this, MainScreen.class);
                startActivity(mh);
                finish();

            }
        },SPLAS_SCREEN);


    }
}