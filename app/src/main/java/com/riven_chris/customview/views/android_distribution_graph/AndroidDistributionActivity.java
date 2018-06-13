package com.riven_chris.customview.views.android_distribution_graph;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/1/31.
 */

public class AndroidDistributionActivity extends AppCompatActivity {

    AndroidBarGraphView barGraphView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_android_distribution);

        barGraphView = findViewById(R.id.bar_graph);
        barGraphView.setData(Distribution.values());
    }
}
