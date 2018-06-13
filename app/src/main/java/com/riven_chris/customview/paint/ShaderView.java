package com.riven_chris.customview.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by riven_chris on 2018/2/26.
 */

public class ShaderView extends View {

    private Paint mPaint;
    private LinearGradient mLinearShader;
    private RadialGradient mRadialGradient;

    public ShaderView(Context context) {
        this(context, null);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mLinearShader = new LinearGradient(200, 200, 400, 400,
                Color.parseColor("#FF0000"), Color.parseColor("#0000FF"),
                Shader.TileMode.REPEAT);

        mRadialGradient = new RadialGradient(300, 1000, 100,
                Color.parseColor("#FF0000"), Color.parseColor("#0000FF"),
                Shader.TileMode.REPEAT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setShader(mLinearShader);
        canvas.drawRect(0, 0, 600, 600, mPaint);

        mPaint.setShader(mRadialGradient);
        canvas.drawRect(0, 700, 600, 1300, mPaint);
    }
}
