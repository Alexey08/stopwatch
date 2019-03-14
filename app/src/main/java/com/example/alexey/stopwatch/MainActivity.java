package com.example.alexey.stopwatch;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int one;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button resetButton = (Button)findViewById(R.id.button2);
        resetButton.setEnabled(false);

        runTimer();
    }

    public void onClickStart(View view) {

        Button startStopButton = (Button)findViewById(R.id.button1);
        Button resetButton = (Button)findViewById(R.id.button2);

                if (running) {
                    running = false;
                    startStopButton.setText("Start");
                    resetButton.setEnabled(false);
                } else  {
                    running = true;
                    startStopButton.setText("Stop");
                    resetButton.setEnabled(true);
                }

    }


    public void onClickReset(View view) {

        running = false;
        one = 0;

        Button startStopButton = (Button)findViewById(R.id.button1);
        startStopButton.setText("Start");

        Button resetButton = (Button)findViewById(R.id.button2);
        resetButton.setEnabled(false);

    }

    private void runTimer() {
        final TextView TextView = (TextView)findViewById(R.id.time_View);
        final Handler Handler = new Handler();
        Handler.post(new Runnable() {
            @Override
            public void run() {
                int hours= one/36000;
                int minuts = one/600%60;
                int secononds = one/10%60;
                int milliseconds = one%10;

                String time = String.format("%02d:%02d:%02d.%d", hours, minuts, secononds, milliseconds);
                TextView.setText(time);
                if (running) {
                    one++;
                }
                Handler.postDelayed(this,100);
            }
        });
    }
}
