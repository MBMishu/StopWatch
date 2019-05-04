package com.example.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int second = 0;
    private boolean running = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }
    public void start(View view){
        running = true;
    }
    public  void stop(View view){
        running = false ;
    }
    public  void  reset(View view){
        running = false;
        second = 0;
    }
    private void  runTimer(){
        final TextView textView =(TextView)findViewById(R.id.textView);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = second/3600;
                int minute = (second/3600)/60;
                int sec = second%60;
                String time = String.format("%d:%02d:%02d",hour,minute,sec);
                textView.setText(time);

                if(running){
                    ++second;
                }
                handler.postDelayed(this,1000);
            }
        });


    }
}
