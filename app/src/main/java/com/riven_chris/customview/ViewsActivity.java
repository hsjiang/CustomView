package com.riven_chris.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.riven_chris.customview.views.android_distribution_graph.AndroidDistributionActivity;
import com.riven_chris.customview.views.page_turning.TurningActivity;

public class ViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
    }

    public void toAndroidGraph(View view) {
        startActivity(new Intent(this, AndroidDistributionActivity.class));
    }

    public void toTuring(View view) {
        startActivity(new Intent(this, TurningActivity.class));
    }
}
