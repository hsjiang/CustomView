package com.riven_chris.customview.paint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/2/26.
 */

public class PaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
    }

    public void toShaderSample(View view) {
        startActivity(new Intent(this, ShaderSampleActivity.class));
    }

    public void toBitmapShaderSample(View view) {
        startActivity(new Intent(this, BitmapShaderActivity.class));
    }

    public void toColorFilter(View view) {
        startActivity(new Intent(this, PaintFilterActivity.class));
    }

    public void toXfermode(View view) {
        startActivity(new Intent(this, XferModeActivity.class));
    }

    public void toLineAndShape(View view) {
        startActivity(new Intent(this, LineAndShapeActivity.class));
    }

    public void toColorOptimize(View view) {
        startActivity(new Intent(this, ColorOptimizeActivity.class));
    }
}
