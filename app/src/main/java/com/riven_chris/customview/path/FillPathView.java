package com.riven_chris.customview.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by riven_chris on 2018/3/19.
 */

public class FillPathView extends View {

    private Path mPath1;
    private Paint mPaint1;

    private String text = "ha haha haha";


    public FillPathView(Context context) {
        this(context, null);
    }

    public FillPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setColor(Color.parseColor("#000000"));
        mPaint1.setStrokeWidth(5);
        mPaint1.setTextSize(80);

        mPath1 = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text, 100, 100, mPaint1);

        mPaint1.setTextScaleX(2);
        canvas.drawText(text, 100, 200, mPaint1);

        mPaint1.reset();
//        mPaint1.set();
    }
}
