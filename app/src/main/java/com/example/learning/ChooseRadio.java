package com.example.learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class ChooseRadio extends AppCompatActivity {

    private  RadioGroup radioGroup , radioGroup1;
    private RadioButton radioButton , radioButton1;
    private  String answer ,answer1 ;
    private Button exitRadio , checkRadio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_radio);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);

        int selectedRadio = radioGroup.getCheckedRadioButtonId();
        int selectedRadio1 = radioGroup1.getCheckedRadioButtonId();

        radioButton = (RadioButton) findViewById(selectedRadio);
        radioButton1 = (RadioButton) findViewById(selectedRadio1);

        exitRadio = (Button) findViewById(R.id.exitRadio);
        checkRadio = (Button) findViewById(R.id.checkRadio);
        exitRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseRadio.this , HomeActivity.class);
                startActivity(intent);
            }
        });



        final MediaPlayer claps =  MediaPlayer.create(this, R.raw.song);


        checkRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioGroup.getCheckedRadioButtonId() == R.id.eightRadio && radioGroup1.getCheckedRadioButtonId() == R.id.oneRadio){
                    claps.start();

                    AlertDialog.Builder builder = new AlertDialog.Builder(ChooseRadio.this);
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
                                    newIntent = new Intent(ChooseRadio.this, FillGap.class);
                                    break;
                                case 1:
                                    newIntent = new Intent(ChooseRadio.this, ChooseSipper.class);
                                    break;
                                case 2:
                                    newIntent = new Intent(ChooseRadio.this, Match.class);
                                    break;

                            }

                            startActivity(newIntent);
                            claps.stop();
                        }
                    });
                    builder.setNegativeButton("Exit exercises ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(ChooseRadio.this ,HomeActivity.class);
                            startActivity(intent);
                            claps.stop();
                        }
                    });
                    builder.show();


                }else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(ChooseRadio.this);
                    builder.setTitle("Something Wrong");
                    builder.setMessage("one of the answers is wrong :( !!");
                    builder.setPositiveButton("Go Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(ChooseRadio.this ,ChooseRadio.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                }
            }
        });


    }
}
