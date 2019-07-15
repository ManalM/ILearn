package com.example.learning;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Drawing extends AppCompatActivity implements View.OnClickListener {

    private Draw draw;
    private Button up, down, red, blue, green, black, yellow, clear , exit;
    private static final int DOTS_INCREMENT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        this.init();
    }

    public void init() {
        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        red = (Button) findViewById(R.id.red);
        blue = (Button) findViewById(R.id.blue);
        green = (Button) findViewById(R.id.green);
        black = (Button) findViewById(R.id.black);
        clear = (Button) findViewById(R.id.clear);
        yellow = (Button) findViewById(R.id.yellow);
        exit = (Button) findViewById(R.id.exit_draw);


        up.setOnClickListener(this);
        down.setOnClickListener(this);
        red.setOnClickListener(this);
        blue.setOnClickListener(this);
        green.setOnClickListener(this);
        clear.setOnClickListener(this);
        black.setOnClickListener(this);
        yellow.setOnClickListener(this);
        exit.setOnClickListener(this);
        draw = (Draw) findViewById(R.id.draw_space);
    }

    @Override
    public void onClick(View v) {

        Button b = (Button) findViewById(v.getId());
        switch (v.getId()) {
            case R.id.blue:
                draw.setmColor(Color.BLUE);
                Log.d("button pressed", b.getText() + "");
                break;
            case R.id.red:
                draw.setmColor(Color.RED);
                Log.d("button pressed", b.getText() + "");
                break;
            case R.id.green:
                draw.setmColor(Color.GREEN);
                Log.d("button pressed", b.getText() + "");
                break;
            case R.id.down:
                draw.changemDotSize(-DOTS_INCREMENT);
                Log.d("button pressed", b.getText() + "");
                break;
            case R.id.up:
                draw.changemDotSize(+DOTS_INCREMENT);
                Log.d("button pressed", b.getText() + "");
                break;
            case R.id.clear:
                draw.reset();
                Log.d("button pressed", b.getText() + "");
                break;
            case R.id.yellow:
                draw.setmColor(Color.YELLOW);
                Log.d("button pressed", b.getText() + "");
                break;
            case R.id.black:
                draw.setmColor(Color.BLACK);
                Log.d("button pressed", b.getText() + "");
                break;

            case R.id.exit_draw:
                Intent intent = new Intent(Drawing.this, HomeActivity.class);
                startActivity(intent);
                break;

        }

    }
}
