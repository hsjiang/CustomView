package com.riven_chris.customview.canvas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.riven_chris.customview.R;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
    }

    public void toText(View view) {
        startActivity(new Intent(this, TextActivity.class));
    }

    public void toClip(View view) {
        startActivity(new Intent(this, ClipActivity.class));
    }

    public void toMatrix(View view) {
        startActivity(new Intent(this, CanvasActivity.class));
    }

    public void toCameraCanvas(View view) {
        startActivity(new Intent(this, CameraCanvasActivity.class));
    }
}
