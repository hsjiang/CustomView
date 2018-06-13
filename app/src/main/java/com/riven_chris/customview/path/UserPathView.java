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
 * Created by riven_chris on 2018/1/22.
 */

public class UserPathView extends View {

    private Path mPath;
    private Paint mPaint;

    public UserPathView(Context context) {
        this(context, null);
    }

    public UserPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UserPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setBackgroundColor(Color.CYAN);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.BLUE);

        mPath = new Path();

        //心形
//        mPath.addArc(200, 200, 400, 400, -225, 225);
//        mPath.arcTo(400, 200, 600, 400, -180, 225, false);
//        mPath.lineTo(400, 550);
//        mPath.close();

        //三圆相交，有趣的图形
        mPath.addCircle(200, 200, 100, Path.Direction.CW);
        mPath.addCircle(300, 200, 100, Path.Direction.CW);
        mPath.addCircle(250, 200, 100, Path.Direction.CW);
        mPath.setFillType(Path.FillType.EVEN_ODD);

        //二阶贝塞尔曲线
//        mPath.moveTo(20, 20);
//        mPath.lineTo(50, 50);
//        mPath.quadTo(150, 460, 400, 100);

        //三阶贝塞尔曲线
//        mPath.cubicTo(100, 100, 200, 400, 400, 100);

        //弧线
//        mPath.lineTo(100, 100);
//        mPath.addArc(200, 200, 400, 400, -90, 180);
//        mPath.close();
//        mPath.arcTo(150, 500, 350, 700, -90, 270, true);
//        mPath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }
}
