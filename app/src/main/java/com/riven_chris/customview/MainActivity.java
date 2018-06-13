package com.riven_chris.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.riven_chris.customview.canvas.CanvasActivity;
import com.riven_chris.customview.paint.PaintActivity;
import com.riven_chris.customview.path.PathActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toPath(View view) {
        startActivity(new Intent(this, PathActivity.class));
    }

    public void toViews(View view) {
        startActivity(new Intent(this, ViewsActivity.class));
    }

    public void toPaint(View view) {
        startActivity(new Intent(this, PaintActivity.class));
    }

    public void toCanvas(View view) {
        startActivity(new Intent(this, CanvasActivity.class));
    }
}
