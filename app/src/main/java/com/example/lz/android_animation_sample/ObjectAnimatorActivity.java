package com.example.lz.android_animation_sample;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class ObjectAnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
    }

    /*Common properties commonly animated on views include:
    Property                                                 Description
    alpha                                                    Fade in or out
    rotation ,  rotationX ,  rotationY                       Spin or flip
    scaleX ,  scaleY                                         Grow or shrink
    x ,  y ,  z                                              Position
    translationX ,  translationY ,  translationZ  (API 21+)  Offset from Position*/

    public void rotateAnimRun(final View view) {
        ObjectAnimator
                .ofFloat(view, "rotationX", 0.0F, 360.0F)
                .setDuration(500)
                .start();
    }

    public void scale1(final View view) {
        ObjectAnimator anim = ObjectAnimator
                .ofFloat(view, "XX", 1F, 0F, 1F)
                .setDuration(1000);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }

    public void scale2(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ).setDuration(1000).start();
    }

    public void removeImage(final View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "alpha", 1, 0.8f, 0.6f, 0.4f, 0.2f);
        //objectAnimator.setDuration(5000);
        //objectAnimator.setRepeatCount(5);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.v("", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.v("", "onAnimationEnd");
                ViewGroup parent = (ViewGroup) view.getParent();
                if (parent != null)
                    parent.removeView(view);

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.v("", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.v("", "onAnimationRepeat");
            }
        });
        objectAnimator.start();
    }

}
