package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
TextView timer;
Button start,reset;
CountDownTimer t;
boolean running;
    Intent r;
long time =600000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=(TextView) findViewById(R.id.textView);
        start=(Button)findViewById(R.id.button);
        r=getIntent();
reset=(Button)findViewById(R.id.button2);
reset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();startActivity(r);
    }
});
start.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startstop();

    }
});
    }
    public void startstop(){
        if(running){stoptimer();}
        else{starttimer();}
    }
    public void starttimer() {
        t =
                new CountDownTimer(time, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        time = millisUntilFinished;
                        updateText();
                    }

                    @Override
                    public void onFinish() {
                    }

                }.start();
running=true;start.setText("pause");
                }
        public void stoptimer () {
        t.cancel();

        running=false;
        start.setText("Start");

        }
        public void updateText(){
        int min=(int)time/60000;
        int sec=(int )(time%60000)/1000;
        String timetes;
        timetes=""+min;
        timetes+=":";
        if(sec<10){timetes+='0';}
        timetes+=sec;
        timer.setText(timetes);
        }

    }