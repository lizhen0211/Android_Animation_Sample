package com.example.lz.android_animation_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PropertyAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
    }

    public void ObjectAnimatorClick(View view) {
        Intent intent = new Intent(PropertyAnimationActivity.this, ObjectAnimatorActivity.class);
        startActivity(intent);
    }
}
