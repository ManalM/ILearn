package com.example.learning;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Draw extends View implements View.OnTouchListener {
    private final int DEFAULT_DOT_SIZE = 10;
    private final int MAX_DOT_SIZE = 100;
    private final int MIN_DOT_SIZE = 5;
    private final int DEFAULT_COLOR = Color.GREEN;
    private int mColor;
    private int mDotSize;
    private Path path;
    private Paint paint;
    private float mY, mX, oldX, oldY;
    private ArrayList<Path> paths;
    private ArrayList<Paint> paints;

    public Draw(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();

    }

    public Draw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();

    }

    public Draw(Context context) {
        super(context);
        this.init();
    }

    public int getmColor() {
        return mColor;
    }

    public void setmColor(int mColor) {
        this.mColor = mColor;
    }

    private void init() {
        mDotSize = DEFAULT_DOT_SIZE;
        mColor = DEFAULT_COLOR;
        this.path = new Path();
        mY = mX = oldX = oldY = (float) 0.0;
        this.setOnTouchListener(this);
        paths = new ArrayList<Path>();
        paints = new ArrayList<Paint>();
        this.addPath(false);
    }

    private void addPath(boolean fill) {
        paint = new Paint();
        path = new Path();
        paint.setColor(mColor);
        if (!fill)
            paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(mDotSize);
        paths.add(path);
        paints.add(paint);
    }

    public void reset() {
        this.init();
        this.invalidate();
    }

    public int getmDotSize() {
        return mDotSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < paths.size(); i++)
            canvas.drawPath(paths.get(i), paints.get(i));
    }

    public void changemDotSize(int increment) {
        this.mDotSize += increment;
        this.mDotSize = Math.min(mDotSize, MAX_DOT_SIZE);
        this.mDotSize = Math.max(mDotSize, MIN_DOT_SIZE);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        mY = event.getY();
        mX = event.getX();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                this.addPath(true);
                this.path.addCircle(mX, mY, mDotSize / 2, Path.Direction.CW);
                this.addPath(false);
                this.path.moveTo(mX, mY);
                break;
            case MotionEvent.ACTION_UP:
                this.addPath(true);
                if (oldX == mX && oldY == mY)
                    this.path.addCircle(mX, mY, mDotSize / 2, Path.Direction.CW);
                break;
            case MotionEvent.ACTION_MOVE:
                this.path.lineTo(mX, mY);
                break;
        }
        this.invalidate();
        oldY = mY;
        oldX = mX;
        return true;
    }
}
