package com.riven_chris.customview.path;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/1/19.
 */

public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_path);
    }

    public void toGetPath(View view) {
        startActivity(new Intent(this, FillPathActivity.class));
    }
}
