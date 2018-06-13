package com.riven_chris.customview.views.android_distribution_graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by riven_chris on 2018/1/30.
 */

public class AndroidBarGraphView extends View {

    private Paint mLinePaint;
    private Paint mRectPaint;
    private Paint mTextPaint;

    private float mVPadding;
    private float mHPadding;

    private Distribution[] mData;
    private RectF mRectF;

    public AndroidBarGraphView(Context context) {
        this(context, null);
    }

    public AndroidBarGraphView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AndroidBarGraphView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

        mRectF = new RectF();

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mVPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
        mHPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, displayMetrics);

        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStyle(Paint.Style.FILL);
        mLinePaint.setColor(Color.parseColor("#FFFFFF"));
        mLinePaint.setStrokeWidth(4);

        mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setColor(Color.parseColor("#6BB739"));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(Color.parseColor("#FFFFFF"));
        float textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, displayMetrics);
        mTextPaint.setTextSize(textSize);

    }

    public void setData(Distribution[] data) {
        mData = data;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#FF515B64"));

        int height = getMeasuredHeight();
        int width = getMeasuredWidth();

        float lineOffset = mLinePaint.getStrokeWidth() / 2.f;
        canvas.drawLine(mHPadding, mVPadding, mHPadding, height - mVPadding, mLinePaint);
        float horizontalY = height - mVPadding + lineOffset;
        canvas.drawLine(mHPadding - lineOffset, horizontalY, width - mHPadding,
                horizontalY, mLinePaint);

        if (mData != null && mData.length > 0) {
            float hLineWidth = width - 2 * mHPadding + lineOffset;
            int size = mData.length;
            float rectWidth = (hLineWidth - mLinePaint.getStrokeWidth()) * 4.f / (5.f * size + 1.f);
            float gapWidth = rectWidth / 4.f;

            float vLineHeight = height - 2 * mVPadding;
            float startOffsetX = mHPadding + mLinePaint.getStrokeWidth() + gapWidth;
            for (Distribution data : mData) {
                float percent = data.getValue();
                String text = data.getKey();
                float rectHeight = vLineHeight * percent / 50.f;

                mRectF.left = startOffsetX;
                mRectF.bottom = height - mVPadding;
                mRectF.top = mRectF.bottom - rectHeight;
                mRectF.right = startOffsetX + rectWidth;
                mRectPaint.setColor(data.getColor());
                canvas.drawRect(mRectF, mRectPaint);

                float textW = mTextPaint.measureText(text);
                float centerX = mRectF.centerX();
                float textStartOffset = centerX - textW / 2f;
                float textStartY = height - mVPadding + mLinePaint.getStrokeWidth() + 40
                        + mTextPaint.getFontMetrics().descent;
                canvas.drawText(text, textStartOffset, textStartY, mTextPaint);

                startOffsetX += gapWidth + rectWidth;
            }
        }
    }
}
