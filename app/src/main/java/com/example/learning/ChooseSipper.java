package com.example.learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChooseSipper extends AppCompatActivity {

    String selected, selected1;
    private Spinner sp1, sp2;
    private Button check, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sipper);

        check = (Button) findViewById(R.id.check_sp);
        exit = (Button) findViewById(R.id.exit_sp);
        sp1 = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        final MediaPlayer claps = MediaPlayer.create(this, R.raw.song);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseSipper.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        final List<String> items = new ArrayList<String>();
        items.add("Choose answer");
        items.add("One");
        items.add("Five");
        items.add("Three");

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(ChooseSipper.this, android.R.layout.simple_spinner_item, items);
        listAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp1.setAdapter(listAdapter);
        sp2.setAdapter(listAdapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected = items.get(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected1 = items.get(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected.equals("Five") && selected1.equals("One")) {
                    claps.start();

                    AlertDialog.Builder builder = new AlertDialog.Builder(ChooseSipper.this);
                    builder.setTitle("wooow!!");
                    builder.setMessage("Congratulation!!");
                    builder.setPositiveButton("Do Another exercises ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent newIntent = null;
                            Random rand = new Random();
                            int index = rand.nextInt();
                            switch (index) {
                                case 0:
                                    newIntent = new Intent(ChooseSipper.this, FillGap.class);
                                    break;
                                case 1:
                                    newIntent = new Intent(ChooseSipper.this, ChooseRadio.class);
                                    break;
                                case 2:
                                    newIntent = new Intent(ChooseSipper.this, Match.class);
                                    break;

                            }

                            startActivity(newIntent);
                            claps.stop();
                        }
                    });
                    builder.setNegativeButton("Exit exercises ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(ChooseSipper.this, HomeActivity.class);
                            startActivity(intent);
                            claps.stop();
                        }
                    });
                    builder.show();
                } else {


                    AlertDialog.Builder builder = new AlertDialog.Builder(ChooseSipper.this);
                    builder.setTitle("Something Wrong");
                    builder.setMessage("one of the answers is wrong :( !!");
                    builder.setPositiveButton("Go Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(ChooseSipper.this, ChooseSipper.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}
