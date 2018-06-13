package com.riven_chris.customview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/2/28.
 */

public class XfermodeView extends View {

    private Paint mPaint;
    private Bitmap mRectBitmap;
    private Bitmap mCircleBitmap;
    private Xfermode xfermode;


    public XfermodeView(Context context) {
        this(context, null);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        /**
         * 离屏缓冲
         *
         * View.setLayerType() 是直接把整个 View 都绘制在离屏缓冲中
         * setLayerType(LAYER_TYPE_HARDWARE) 是使用 GPU 来缓冲
         * setLayerType(LAYER_TYPE_SOFTWARE) 是直接直接用一个 Bitmap 来缓冲
         */
//        setLayerType(LAYER_TYPE_SOFTWARE, null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

        Drawable rectDrawable = ContextCompat.getDrawable(getContext(), R.drawable.retangle);
        mRectBitmap = Bitmap.createBitmap(rectDrawable.getIntrinsicWidth(), rectDrawable.getIntrinsicHeight()
                , Bitmap.Config.ARGB_8888);
        Canvas rectCanvas = new Canvas(mRectBitmap);
        rectDrawable.setBounds(0, 0, rectCanvas.getWidth(), rectCanvas.getHeight());
        rectDrawable.draw(rectCanvas);

        Drawable circleDrawable = ContextCompat.getDrawable(getContext(), R.drawable.circle);
        mCircleBitmap = Bitmap.createBitmap(circleDrawable.getIntrinsicWidth(), circleDrawable.getIntrinsicHeight()
                , Bitmap.Config.ARGB_8888);
        Canvas circleCanvas = new Canvas(mCircleBitmap);
        circleDrawable.setBounds(0, 0, circleCanvas.getWidth(), circleCanvas.getHeight());
        circleDrawable.draw(circleCanvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(mRectBitmap, 0, 0, mPaint);
        mPaint.setXfermode(xfermode);
        canvas.drawBitmap(mCircleBitmap, 0, 0, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(saved);
    }
}
