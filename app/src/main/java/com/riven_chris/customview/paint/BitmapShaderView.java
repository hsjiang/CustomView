package com.riven_chris.customview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.riven_chris.customview.R;

/**
 * Created by riven_chris on 2018/2/26.
 */

public class BitmapShaderView extends View {

    private Paint mPaint;
    private BitmapShader mIconShader;
    private ComposeShader mComposeShader;

    public BitmapShaderView(Context context) {
        this(context, null);
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        mIconShader = new BitmapShader(Bitmap.createScaledBitmap(icon, 600, 600,
                false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Bitmap launcher = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Shader launcherShader = new BitmapShader(Bitmap.createScaledBitmap(launcher, 300,
                300, false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        mComposeShader = new ComposeShader(mIconShader, launcherShader, PorterDuff.Mode.SRC_OVER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setShader(mIconShader);
//        canvas.drawCircle(300, 300, 300, mPaint);

        mPaint.setShader(mComposeShader);
        canvas.drawCircle(300, 300, 300, mPaint);
    }
}
