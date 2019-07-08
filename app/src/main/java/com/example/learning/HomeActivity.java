package com.example.learning;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    private TextView numbers , exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        numbers = (TextView) findViewById(R.id.numbers);
        exercise= (TextView) findViewById(R.id.exercise);



        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = null;
                Random ran = new Random();
                int index = ran.nextInt(4);
                switch (index) {
                    case 0:
                        newIntent = new Intent(HomeActivity.this, ChooseRadio.class);
                        break;
                    case 1:
                        newIntent = new Intent(HomeActivity.this, ChooseSipper.class);
                        break;
                    case 2:
                        newIntent = new Intent(HomeActivity.this, Match.class);
                        break;
                    case 3:
                        newIntent = new Intent(HomeActivity.this, FillGap.class);

                }

                startActivity(newIntent);
            }
        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, NumbersActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
