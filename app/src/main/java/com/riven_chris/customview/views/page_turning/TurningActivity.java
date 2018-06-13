package com.riven_chris.customview.views.page_turning;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.riven_chris.customview.R;

public class TurningActivity extends AppCompatActivity {

    ImageView ivTop;
    ImageView ivBottom;
    ImageView ivAnimTop;
    ImageView ivAnimBottom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turning);
        ivTop = findViewById(R.id.iv_top);
        ivBottom = findViewById(R.id.iv_bottom);
        ivAnimTop = findViewById(R.id.iv_anim1);
        ivAnimBottom = findViewById(R.id.iv_anim2);

    }

    public void start(View view) {
        ivTop.setImageResource(R.drawable.img_signing_board_2a);
        ivBottom.setImageResource(R.drawable.img_signing_board_2b);

        Log.d("turning", "height: " + ivTop.getHeight());
        ivAnimTop.setPivotY(ivTop.getHeight());
        ivAnimTop.setImageResource(R.drawable.img_signing_board_2a);
        ivAnimTop.setVisibility(View.VISIBLE);

        ivTop.setImageResource(R.drawable.img_signing_board_5a);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivAnimTop, "rotationX", 0, -90);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ivAnimTop.setVisibility(View.GONE);
                ivAnimBottom.setPivotY(0);
                ivAnimBottom.setImageResource(R.drawable.img_signing_board_5b);
                ivAnimBottom.setRotationX(-90);
                ivAnimBottom.setVisibility(View.VISIBLE);
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivAnimBottom, "rotationX", -90, 0);
                objectAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ivAnimBottom.setVisibility(View.GONE);
                        ivBottom.setImageResource(R.drawable.img_signing_board_5b);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                objectAnimator.setDuration(500);
                objectAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.setDuration(500);
        objectAnimator.addUpdateListener(animation -> {
                    Log.d("turning", "animation: " + animation.getAnimatedValue());
//                    float degree = (float) animation.getAnimatedValue();
//                    if (degree >= -90) {
//                        ivAnimTop.setImageResource(R.drawable.img_signing_board_5b);
//                    }
                }
        );
        objectAnimator.start();
    }
}
