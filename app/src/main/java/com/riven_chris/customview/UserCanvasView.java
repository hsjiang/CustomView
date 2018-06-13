package com.riven_chris.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by riven_chris on 2018/1/18.
 */

public class UserCanvasView extends View {

    @ColorInt
    private int mColor = Color.parseColor("#88880000");

    private Paint mPaint;

    private int mRadius = 100;


    public UserCanvasView(Context context) {
        this(context, null);
    }

    public UserCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UserCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.icon));

        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = getMeasuredHeight();
        int width = getMeasuredWidth();

        mPaint.setColor(Color.RED);
        canvas.drawCircle(width / 2, height / 2, mRadius, mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(100, 150, 200, 250, mPaint);

        mPaint.setColor(Color.CYAN);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(300, 200, mPaint);

        mPaint.setColor(Color.RED);
        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawPoints(points, 2, 8, mPaint);
        canvas.drawPoints(points, mPaint);

        RectF rect = new RectF(400, 50, 1000, 400);
        canvas.drawOval(rect, mPaint);
        canvas.drawRect(rect, mPaint);

        mPaint.setColor(Color.BLUE);
//        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rect, 0, 140, true, mPaint);
    }
}
