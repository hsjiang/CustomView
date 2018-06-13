package com.riven_chris.customview.views.android_distribution_graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by riven_chris on 2018/2/5.
 */

public class AndroidPieGraphView extends View {

    private int mStartAngle = -270;
    private int mGapAngle = 10;
    private Paint mArcPaint;

    private Distribution[] mData;

    public AndroidPieGraphView(Context context) {
        this(context, null);
    }

    public AndroidPieGraphView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AndroidPieGraphView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(Distribution[] data) {
        mData = data;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        float[] centerPoint = {height / 2f, width / 2f};
        float radius = (height > width ? width : height) * 2 / 3f;

        if (mData != null) {
            int gapSize = mData.length;
            double remainL = 2 * Math.PI - (gapSize * mGapAngle * Math.PI / 180.d);
            int sumValue = 0;
            for (Distribution data : mData) {
                sumValue += data.getValue();
            }

            for (Distribution data : mData) {
                
            }
        }
    }
}
