package com.example.learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class FillGap extends AppCompatActivity {


    private TextView zero , four;
    private Button button , exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_gap);

        exit = (Button) findViewById(R.id.button2);
        four= (TextView) findViewById(R.id.four);
        zero = (TextView) findViewById(R.id.zero);
        button = (Button) findViewById(R.id.button);
        final MediaPlayer claps =  MediaPlayer.create(this, R.raw.song);


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FillGap.this , HomeActivity.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (zero.getText().toString().equals("zero") ||  four.getText().toString().equals("four") ){

                    claps.start();

                    AlertDialog.Builder builder = new AlertDialog.Builder(FillGap.this);
                    builder.setTitle("Woow !!!");
                    builder.setMessage("Congratulation!!");
                    builder.setPositiveButton("Do another exercise", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent newIntent = null;
                            Random rand = new Random();

                            int index = rand.nextInt(3);
                            switch (index) {
                                case 0:
                                    newIntent = new Intent(FillGap.this, ChooseRadio.class);
                                    break;
                                case 1:
                                    newIntent = new Intent(FillGap.this, ChooseSipper.class);
                                    break;
                                case 2:
                                    newIntent = new Intent(FillGap.this, Match.class);
                                    break;

                            }

                            startActivity(newIntent);
                            claps.stop();
                        }
                    });
                    builder.setNegativeButton("Exit exercises ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(FillGap.this ,HomeActivity.class);
                            startActivity(intent);
                            claps.stop();
                        }
                    });
                    builder.show();


                }else {



                    AlertDialog.Builder builder = new AlertDialog.Builder(FillGap.this);
                    builder.setTitle("Something Wrong");
                    builder.setMessage("one of the answers is wrong :( !!");
                    builder.setPositiveButton("Go Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(FillGap.this ,FillGap.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();

                }
            }
        });
    }
}
