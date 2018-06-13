package com.riven_chris.customview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/2/27.
 */

public class PaintFilterView extends View {

    private Paint mLPaint;
    private LightingColorFilter mLColorFilter;
    private PorterDuffColorFilter mPDColorFilter;
    private ColorMatrixColorFilter mCMColorFilter;

    private Paint mMaskPaint;

    private Bitmap mTargetBitmap;

    public PaintFilterView(Context context) {
        this(context, null);
    }

    public PaintFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mTargetBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon),
                300, 300, false);

        mLPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLColorFilter = new LightingColorFilter(Color.parseColor("#00ffff"),
                Color.parseColor("#000000"));
        mLPaint.setColorFilter(mLColorFilter);

        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mMaskPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mTargetBitmap, 0, 0, mLPaint);

        mMaskPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(mTargetBitmap, 500, 500, mMaskPaint);

        mMaskPaint.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 15));
        canvas.drawBitmap(mTargetBitmap, 500, 1000, mMaskPaint);
    }
}
