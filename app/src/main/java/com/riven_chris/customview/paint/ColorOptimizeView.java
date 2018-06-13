package com.riven_chris.customview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/3/16.
 */

public class ColorOptimizeView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

    public ColorOptimizeView(Context context) {
        this(context, null);
    }

    public ColorOptimizeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorOptimizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        mBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.icon, options), 2400, 2400, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawBitmap(mBitmap, 100, 100, mPaint);
//
//        mPaint.setDither(true);
//        canvas.drawBitmap(mBitmap, 100, 600, mPaint);

        //设置是否使用双线性过滤来绘制 Bitmap（默认使用的是最近邻插值过滤）
        //这里貌似被mBitmap创建时传的filter值影响了
        mPaint.setFilterBitmap(false);
        canvas.drawBitmap(mBitmap, 100, 100, mPaint);
    }
}
