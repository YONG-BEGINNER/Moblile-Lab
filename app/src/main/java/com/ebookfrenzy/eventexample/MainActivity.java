package com.ebookfrenzy.eventexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener
{
    private TextView gestureText;
    private GestureDetectorCompat gDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureText = findViewById(R.id.statusText);
        this.gDetector = new GestureDetectorCompat(this,this);
        gDetector.setOnDoubleTapListener(this);
        Button button = findViewById(R.id.myButton);
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView statusText =
                                findViewById(R.id.statusText);
                        statusText.setText("Button clicked");
                    }
                }
        );
        button.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        TextView statusText =
                                findViewById(R.id.statusText);
                        statusText.setText("Long button click");
                        return true;
                    }
                }
        );
    }
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        gestureText.setText("onFling");
        return true;
    }
    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("onLongPress");
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        return true;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        gestureText.setText("onSingleTapConfirmed");
        return true;
    }
    @Override
    public boolean onDoubleTap(MotionEvent event) {
        gestureText.setText("onDoubleTap");
        return true;
    }
    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText ("onDown");
        return true;
    }
    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("onShowPress");
    }
    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        gestureText.setText("onDoubleTapEvent");
        return true;
    }
    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
// Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }
}