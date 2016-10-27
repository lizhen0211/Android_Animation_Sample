package com.example.lz.android_animation_sample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AnimatorSetActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        imageView = (ImageView) findViewById(R.id.img);
    }

    public void onRunTogetherClick(View view) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 2f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 2f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000);
        animatorSet.playTogether(animator1, animator2);
        animatorSet.start();
    }

    public void onRunAfterClick(View view) {
        float x = imageView.getX();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 2f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 2f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "x", x, 0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(imageView, "x", x);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator1).with(animator2);
        animatorSet.play(animator2).with(animator3);
        animatorSet.play(animator4).after(animator3);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }
}
