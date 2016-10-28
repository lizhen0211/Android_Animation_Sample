package com.example.lz.android_animation_sample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAnimationActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        textView = (TextView) findViewById(R.id.textview);
    }

    public void onTextViewClick(View view) {
        view.animate().alpha(0.5f).rotation(90f).
                scaleX(2).xBy(100).yBy(100).setDuration(1000).setStartDelay(10).
                setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Toast.makeText(ViewAnimationActivity.this, "Started...", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
