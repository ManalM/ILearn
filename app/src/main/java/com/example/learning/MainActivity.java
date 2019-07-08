package com.example.learning;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
   private TextView percent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        percent = (TextView) findViewById(R.id.percent);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressAnimation();


    }
    public void progressAnimation(){

        ProgressBarAnimated bar = new ProgressBarAnimated(this,progressBar,percent,0,100f);
        bar.setDuration(8000);
        progressBar.setAnimation(bar);

    }
}
