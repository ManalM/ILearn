package com.example.learning;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Match extends AppCompatActivity {

    private Button check, exit;
    private ImageView targetThree , targetSix , apple , docks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        check = (Button) findViewById(R.id.check_match);
        exit = (Button) findViewById(R.id.exit_match);
        targetSix = (ImageView) findViewById(R.id.target6);
        targetThree = (ImageView) findViewById(R.id.target3);
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
        targetSix.setOnDragListener(dragListener);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            ClipData clipData = ClipData.newPlainText("","");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData ,dragShadowBuilder,v,0);

            return true;
        }
    };

    View.OnDragListener dragListener1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent){

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
            if (view.getId() == R.id.docks){
                view.animate()
                        .x(docks.getX())
                        .y(docks.getY())
                        .setDuration(700)
                        .start();
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
            switch (dragEvent){

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                        break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.apple){

                        view.animate()
                                .x(apple.getX())
                                .y(apple.getY())
                                .setDuration(700)
                                .start();
                    }

                            break;
            }

            return true;
        }
    };
}
