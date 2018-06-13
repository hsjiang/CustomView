package com.riven_chris.customview.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by riven_chris on 2018/3/16.
 */

public class LineAndShapeView extends View {

    private Paint mStrokeWidthPaint;

    private Paint mCapPaint;

    private Paint mJoinPaint;

    public LineAndShapeView(Context context) {
        this(context, null);
    }

    public LineAndShapeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineAndShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mStrokeWidthPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mStrokeWidthPaint.setColor(Color.parseColor("#000000"));
        mStrokeWidthPaint.setStyle(Paint.Style.STROKE);
        mStrokeWidthPaint.setStrokeWidth(0);//difference between 0 and 1

        mCapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCapPaint.setColor(Color.parseColor("#000000"));
        mCapPaint.setStrokeWidth(50);

        mJoinPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mJoinPaint.setColor(Color.parseColor("#000000"));
        mJoinPaint.setStyle(Paint.Style.STROKE);
        mJoinPaint.setStrokeWidth(50);
        //对setStrokeJoin的补充，设置MITER型延长线的最大值
        // miter = 1/sin(α/2) α:拐角大小
        mJoinPaint.setStrokeMiter(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int y = 200;
        int startX = 100;
        canvas.drawCircle(200, y, 100, mStrokeWidthPaint);

        y += 150;
        mCapPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(startX, y, 800, y, mCapPaint);
        y += 70;
        mCapPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(startX, y, 800, y, mCapPaint);
        y += 70;
        mCapPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(startX, y, 800, y, mCapPaint);

        y += 100;
        mJoinPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(getPath(startX, y), mJoinPaint);
        mJoinPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(getPath(startX + 400, y), mJoinPaint);
        mJoinPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(getPath(startX + 800, y), mJoinPaint);
    }

    private Path getPath(float x, float y) {
        Path path = new Path();
        path.moveTo(x, y);
        path.lineTo(x + 300, y);
        path.lineTo(x + 40, y + 200);
        return path;
    }
}
