package com.example.learning;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAnimated extends Animation {

    private Context context;
    private ProgressBar progressBar;
    private float from;
    private float to;
    private TextView percent;

    public ProgressBarAnimated(Context context, ProgressBar progressBar, TextView percent, float from, float to) {

        this.context = context;
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
        this.percent = percent;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from)* interpolatedTime;
        progressBar.setProgress((int) value);
        percent.setText((int) value + "%");

        if (value == to){

            context.startActivity(new Intent(context, HomeActivity.class));
        }
    }
}
