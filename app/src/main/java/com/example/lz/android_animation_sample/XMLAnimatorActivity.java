package com.example.lz.android_animation_sample;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class XMLAnimatorActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlanimator);
        imageView = (ImageView) findViewById(R.id.img1);
    }

    public void onScaleXClick(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scalex);
        animator.setTarget(imageView);
        animator.start();
    }


    public void onScaleXAndYClick(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale_x_y);
        animator.setTarget(imageView);
        imageView.setPivotX(0);
        imageView.setPivotY(0);
        animator.start();
    }
}
