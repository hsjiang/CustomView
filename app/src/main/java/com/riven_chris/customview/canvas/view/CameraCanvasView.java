package com.riven_chris.customview.canvas.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/4/20.
 */

public class CameraCanvasView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Camera mCamera;

    private float pivotX;
    private float pivotY;

    private float offsetX = 200;
    private float offsetY = 200;

    int degree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 360);

    public CameraCanvasView(Context context) {
        this(context, null);
    }

    public CameraCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Drawable drawable = getResources().getDrawable(R.drawable.four, null);
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        width = height = 1000;
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);

        pivotX = width / 2 + offsetX;
        pivotY = height / 2 + offsetY;

        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);

        mCamera = new Camera();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float newZ = - displayMetrics.density * 6;
        mCamera.setLocation(0, 0, newZ);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawBitmap(mBitmap, offsetX, offsetY, mPaint);

        canvas.save();
        mCamera.save();

        mCamera.rotateX(degree);
        canvas.translate(pivotX, pivotY);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-pivotX, -pivotY);


//        mCamera.translate(400, 0, 400);
//        mCamera.applyToCanvas(canvas);




        mCamera.restore();
        canvas.drawBitmap(mBitmap, offsetX, offsetY, mPaint);
        canvas.restore();
    }
}
