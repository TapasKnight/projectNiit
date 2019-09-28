package com.example.check.Activities;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import com.example.check.R;

public class stopwatchActivity extends AppCompatActivity {

    Button btnStart,btnStop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timer;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialoguestopwatch);


        btnStart = findViewById(R.id.startWatch);
        btnStop = findViewById(R.id.stopWatch);
        timer = findViewById(R.id.timer);


        icanchor = findViewById(R.id.anchor);


        roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
                icanchor.clearAnimation();
            }
        });




    }
}
