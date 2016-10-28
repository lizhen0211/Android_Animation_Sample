package com.example.lz.android_animation_sample;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class LayoutAnimationActivity extends AppCompatActivity {

    private LinearLayout containerLayout;

    private GridLayout gridLayout;

    private CheckBox appearingCheckBox;

    private CheckBox changeAppearingCheckBox;

    private CheckBox disappearingCheckBox;

    private CheckBox changeDisappearingCheckBox;

    private CheckBox changeCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animations);
        containerLayout = (LinearLayout) findViewById(R.id.container);
        gridLayout = (GridLayout) findViewById(R.id.grid_layout);
        appearingCheckBox = (CheckBox) findViewById(R.id.appearing);
        changeAppearingCheckBox = (CheckBox) findViewById(R.id.change_appearing);
        disappearingCheckBox = (CheckBox) findViewById(R.id.disappearing);
        changeDisappearingCheckBox = (CheckBox) findViewById(R.id.change_disappearing);
        changeCheckBox = (CheckBox) findViewById(R.id.change);

        appearingCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        changeAppearingCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        disappearingCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        changeDisappearingCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        changeCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    /*LayoutTransition.APPEARING 当一个View在ViewGroup中出现时，对此View设置的动画
    LayoutTransition.CHANGE_APPEARING 当一个View在ViewGroup中出现时，对此View对其他View位置造成影响，对其他View设置的动画
    LayoutTransition.DISAPPEARING  当一个View在ViewGroup中消失时，对此View设置的动画
    LayoutTransition.CHANGE_DISAPPEARING 当一个View在ViewGroup中消失时，对此View对其他View位置造成影响，对其他View设置的动画
    LayoutTransition.CHANGE 不是由于View出现或消失造成对其他View位置造成影响，然后对其他View设置的动画。*/
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.setAnimator(LayoutTransition.APPEARING, appearingCheckBox.isChecked() ?
                    layoutTransition.getAnimator(LayoutTransition.APPEARING) : null);
            layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeAppearingCheckBox.isChecked() ?
                    layoutTransition.getAnimator(LayoutTransition.CHANGE_APPEARING) : null);
            layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, disappearingCheckBox.isChecked() ?
                    layoutTransition.getAnimator(LayoutTransition.DISAPPEARING) : null);
            layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeDisappearingCheckBox.isChecked() ?
                    layoutTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING) : null);
            layoutTransition.setAnimator(LayoutTransition.CHANGING, changeCheckBox.isChecked() ?
                    layoutTransition.getAnimator(LayoutTransition.CHANGING) : null);
            gridLayout.setLayoutTransition(layoutTransition);
        }
    };


    public void onAddBtnClick(View view) {
        final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).
                inflate(R.layout.layout_animation_item, containerLayout, false);

        TextView textView = (TextView) newView.findViewById(R.id.text);
        ImageButton btn = (ImageButton) newView.findViewById(R.id.delete_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                containerLayout.removeView(newView);
            }
        });
        textView.setText(String.valueOf(new Random().nextInt()));
        containerLayout.addView(newView, 0);
    }

    public void onAddBtn2Click(View view) {
        final Button button = new Button(this);
        button.setText(String.valueOf(new Random().nextInt()));
        gridLayout.addView(button, Math.min(1, gridLayout.getChildCount()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayout.removeView(button);
            }
        });
    }
}
