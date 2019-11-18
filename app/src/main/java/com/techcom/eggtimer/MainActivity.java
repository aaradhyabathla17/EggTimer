package com.techcom.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   TextView timer;
   Button Go;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         seekBar=(SeekBar) findViewById(R.id.sleekbar);
        seekBar.setMax(600);
        seekBar.setProgress(30);


        timer=(TextView) findViewById(R.id.timer);
        Go=(Button) findViewById(R.id.go);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=progress/60;
                int sec=progress-(min*60);
                String secs=Integer.toString(sec);
                if(sec<=9)
                {
                    secs="0"+sec;
                }
                timer.setText(Integer.toString(min)+":"+secs);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer=new CountDownTimer(seekBar.getProgress()*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                         updateTimer((int)millisUntilFinished/1000);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this
                                ,"Times UP!",Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();

            }
        });
    }
    public  void updateTimer(int secondsLeft)
    {
        int min=secondsLeft/60;
        int sec=secondsLeft-(min*60);
        String secs=Integer.toString(sec);
        if(sec<=9)
        {
            secs="0"+sec;
        }
        timer.setText(Integer.toString(min)+":"+secs);

    }
}
