package com.example.lz.android_animation_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPropertyAnimationClick(View view) {
        Intent intent = new Intent(MainActivity.this, PropertyAnimationActivity.class);
        startActivity(intent);
    }

    public void onViewAnimationClick(View view) {

    }

    public void onDrawableAnimationClick(View view) {

    }

    public void onLayoutAnimationClick(View view) {
        Intent intent = new Intent(MainActivity.this, LayoutAnimationActivity.class);
        startActivity(intent);
    }
}
