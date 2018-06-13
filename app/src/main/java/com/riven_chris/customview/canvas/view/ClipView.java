package com.riven_chris.customview.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/4/19.
 */

public class ClipView extends View {

    private Paint mPaint;
    private Bitmap mBitmap1;
    private Path mPath1;
    private Path mPath2;

    public ClipView(Context context) {
        this(context, null);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundColor(Color.LTGRAY);
        mBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.four);
        mBitmap1 = Bitmap.createScaledBitmap(mBitmap1, 600, 400, true);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);

        mPath1 = new Path();
        mPath1.addOval(100, 0, 400, 300, Path.Direction.CW);
        mPath1.setFillType(Path.FillType.EVEN_ODD);

        mPath2 = new Path();
        mPath2.addOval(100, mBitmap1.getHeight(), 400, mBitmap1.getHeight() + 300, Path.Direction.CW);
        mPath2.toggleInverseFillType();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            canvas.clipOutRect(200, 100, 600, 500);
//        }
//        canvas.clipRect(200, 100, 600, 500);
        canvas.clipPath(mPath1);
        canvas.drawBitmap(mBitmap1, 0, 0, mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(mPath2);
        canvas.drawBitmap(mBitmap1, 0, mBitmap1.getHeight(), mPaint);
        canvas.restore();

//        canvas.rotate(45);
        canvas.save();
        canvas.translate(200, 0);
        int top = mBitmap1.getHeight() * 3;
        canvas.scale(1.5f, 1.5f, mBitmap1.getWidth() / 2.f, top);
        canvas.skew(0.1f, 0.3f);
        canvas.drawBitmap(mBitmap1, 0, top - mBitmap1.getHeight() / 2.2f, mPaint);
        canvas.restore();

    }
}
