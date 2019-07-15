package com.example.learning;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class Match extends AppCompatActivity {

    private Button check, exit;
    private ImageView  apple, docks;
    private LinearLayout targetThree, targetSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        check = (Button) findViewById(R.id.check_match);
        exit = (Button) findViewById(R.id.exit_match);
        targetSix = (LinearLayout) findViewById(R.id.target6);
        targetThree = (LinearLayout) findViewById(R.id.target3);
        apple = (ImageView) findViewById(R.id.apple);
        docks = (ImageView) findViewById(R.id.docks);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Match.this, HomeActivity.class);
                startActivity(intent);
            }
        });


        apple.setOnLongClickListener(longClickListener);
        docks.setOnLongClickListener(longClickListener);
        targetThree.setOnDragListener(dragListener1);
        targetSix.setOnDragListener(dragListener1);

      final   MediaPlayer claps = MediaPlayer.create(this,R.raw.song);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                claps.start();

                AlertDialog.Builder builder = new AlertDialog.Builder(Match.this);
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
                                newIntent = new Intent(Match.this, ChooseRadio.class);
                                break;
                            case 1:
                                newIntent = new Intent(Match.this, ChooseSipper.class);
                                break;
                            case 2:
                                newIntent = new Intent(Match.this,FillGap.class);
                                break;

                        }

                        startActivity(newIntent);
                        claps.stop();
                    }
                });
                builder.setNegativeButton("Exit exercises ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Match.this ,HomeActivity.class);
                        startActivity(intent);
                        claps.stop();
                    }
                });
                builder.show();
            }
        });
    }


    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);

            return true;
        }
    };

    View.OnDragListener dragListener1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.docks && v.getId() == R.id.target3) {
                        LinearLayout source = (LinearLayout) view.getParent();
                        source.removeView(view);

                        LinearLayout target = (LinearLayout) v;
                      docks.setVisibility(View.GONE);
                        target.addView(view);
                    } else if (view.getId() == R.id.apple && v.getId() == R.id.target6){
                        LinearLayout source = (LinearLayout) view.getParent();
                        source.removeView(view);

                        LinearLayout target = (LinearLayout) v;
                        apple.setVisibility(View.GONE);
                        target.addView(view);
                    }
                    break;
            }

            return true;
        }
    };
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {


            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.apple && v.getId() == R.id.target6) {
                        LinearLayout source = (LinearLayout) view.getParent();
                        source.removeView(view);

                        LinearLayout target = (LinearLayout) v;
                        apple.setVisibility(View.GONE);
                        target.addView(view);
                    /*    view.animate()
                                .x(apple.getX())
                                .y(apple.getY())
                                .setDuration(700)
                                .start();*/
                    } else {
                        Toast.makeText(Match.this, "not Good", Toast.LENGTH_SHORT).show();

                    }
                    break;
            }

            return true;
        }
    };

}
