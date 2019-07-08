package com.example.learning;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NumbersActivity extends AppCompatActivity {

    private ImageView one ,two,three,four,five,six,seven,eight,nine,zero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        zero = (ImageView) findViewById(R.id.zero);
        one = (ImageView) findViewById(R.id.one);
        two = (ImageView) findViewById(R.id.two);
        three = (ImageView) findViewById(R.id.three);
        four = (ImageView) findViewById(R.id.four);
        five = (ImageView) findViewById(R.id.five);
        six = (ImageView) findViewById(R.id.six);
        seven = (ImageView) findViewById(R.id.seven);
        eight = (ImageView) findViewById(R.id.eight);
        nine = (ImageView) findViewById(R.id.nine);



       final MediaPlayer song = MediaPlayer.create(this, R.raw.song);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song.start();
            }
        });
    }
}
