package com.riven_chris.customview.canvas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Locale;

/**
 * Created by riven_chris on 2018/3/20.
 */

public class DrawTextView extends View {

    private Paint mPaint;
    private TextPaint mTextPaint;
    private Path mPath;
    private StaticLayout mStaticLayout1;
    private StaticLayout mStaticLayout2;
    private Rect text2Bounds;
    private float[] text2Widths;
    private float[] text3WidthsArray;

    private String text = " hello world! hello world!";
    private String text1 = " StaticLayout is a Layout for text\n that will not be edited after it\n is laid out.";
    private String text2 = "雨骨雨骨雨骨雨骨";
    private String text3 = "Measure the text, stopping early if the measured width exceeds maxWidth. Return the number of chars that were measured, and if measuredWidth is not null, return in it the actual width measured.";
    private int text2OffsetX = 100;

    public DrawTextView(Context context) {
        this(context, null);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        setLayerType(LAYER_TYPE_SOFTWARE, null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#000000"));

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(Color.parseColor("#000000"));
        mTextPaint.setStrokeWidth(4);
        mTextPaint.setTextSize(60);
//        mTextPaint.setStrikeThruText(true);
//        mTextPaint.setTextSkewX(-0.5f);
        mTextPaint.setLetterSpacing(0.1f);
//        mTextPaint.setFontFeatureSettings("smcp");

        mPath = new Path();
        mPath.addCircle(300, 300, 200, Path.Direction.CW);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mStaticLayout1 = StaticLayout.Builder.obtain(text1, 0, text1.length() - 1,
                    mTextPaint, 800)
                    .setMaxLines(4)
                    .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                    .setBreakStrategy(Layout.BREAK_STRATEGY_BALANCED)
                    .setHyphenationFrequency(Layout.HYPHENATION_FREQUENCY_FULL)
//                    .setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD)
//                    .setIndents()
                    .setTextDirection(TextDirectionHeuristics.LTR)
                    .setLineSpacing(4, 1)
                    .setIncludePad(true)
                    .setEllipsizedWidth(500)
                    .setEllipsize(TextUtils.TruncateAt.END)
                    .build();
        } else {
            mStaticLayout1 = new StaticLayout(text1, mTextPaint, 800, Layout.Alignment.ALIGN_NORMAL,
                    2, 4, true);
        }

        text2Bounds = new Rect();
        text2Widths = new float[text2.length()];

        text3WidthsArray = new float[text3.length()];
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(mPath, mPaint);

        canvas.drawTextOnPath(text, mPath, 0, -10, mTextPaint);

        canvas.translate(0, 600);
        mStaticLayout1.draw(canvas);

        canvas.translate(0, 600);
//        mTextPaint.setTextAlign(Paint.Align.LEFT);
        mTextPaint.setTextLocale(Locale.TAIWAN);
        canvas.drawText(text2, text2OffsetX, 0, mTextPaint);

//        mTextPaint.setLetterSpacing(10);
//        float spacing = mTextPaint.getFontSpacing();
//        Log.d("DrawText", "spacing: " + spacing);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        Log.d("DrawText", "top: " + fontMetrics.top);
        Log.d("DrawText", "bottom: " + fontMetrics.bottom);
        Log.d("DrawText", "ascent: " + fontMetrics.ascent);
        Log.d("DrawText", "descent: " + fontMetrics.descent);
        Log.d("DrawText", "leading: " + fontMetrics.leading);

        //获得文字的'显示'范围
        mTextPaint.getTextBounds(text2, 0, text2.length(), text2Bounds);
        text2Bounds.left += text2OffsetX;
        text2Bounds.right += text2OffsetX;
        mTextPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(text2Bounds, mTextPaint);
        mTextPaint.setStyle(Paint.Style.FILL);

        //文字'占用'的宽度，总是比 text2Bounds 大一点点
        float measuredTextWidth = mTextPaint.measureText(text2);
        int measuredOffsetY = text2Bounds.bottom + 30;
        canvas.drawLine(text2OffsetX, measuredOffsetY, text2OffsetX + measuredTextWidth,
                measuredOffsetY, mTextPaint);

        //获取字符串中每个字符的宽度
        mTextPaint.getTextWidths(text3, text3WidthsArray);

        int start = 0;
        int offsetY = 150;
        while (start < text3.length()) {
            int measuredCount = mTextPaint.breakText(text3, start, text3.length(), true, 1000, text3WidthsArray);
            int end = start + measuredCount;
            canvas.drawText(text3, start, end, 150, offsetY, mTextPaint);
            start += measuredCount;
            offsetY += mTextPaint.getFontSpacing();
        }

        int text2Length = text2.length();
        //光标坐标
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//            float cursorX = mTextPaint.getRunAdvance(text2, 0, text2Length, 0, text2Length, false, text2Length);
        }

        //检查指定的字符串中是否是一个单独的字形
//     mTextPaint.hasGlyph()

    }
}
