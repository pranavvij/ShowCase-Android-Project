package com.example.pranavvij.showcaselibrary;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by pranav vij on 7/1/2015.
 */
public class FlipImage extends View {
    private Paint CirclePaint;
    private static final int PRESSED_COLOR_LIGHTUP = 255 / 25;
    private int outerRadius=50;
    int pressedRingWidth=10;
    private int centerX=0,centerY=0;
    private int CusX=0,CusY=0;
    int color= Color.parseColor("#4366C5");
    private int value=0;
    private boolean isretrieving=false;
    private int fixedValueWidth;
    public FlipImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    public FlipImage(Context context) {
        super(context);
        init(context, null);
    }

    public FlipImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FlipImage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }
    void init(Context context, AttributeSet attrs){
           this.setAlpha(.6f);
           this.setPadding(10,10,10,10);
           CirclePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
           CirclePaint.setStyle(Paint.Style.FILL);
           CirclePaint.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));
        if (attrs != null) {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleButton);
            color = a.getColor(R.styleable.CircleButton_cb_color, color);
            a.recycle();
        }
        setColor(color);
     }

    public void setColor(int color) {
        this.color = color;
        CirclePaint.setColor(color);
        this.invalidate();
    }

    public int getColor() {
        return color;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        centerX=Math.abs(left-right)/2;
        centerY=Math.abs(top-bottom)/2;
        CusX=left+centerX;
        CusY=top+centerY;
        Log.d("value X", "" + CusX);
        Log.d("value Y",""+CusY);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        CirclePaint.setShader(new RadialGradient(centerX, centerY, 2*outerRadius+value,color, Color.TRANSPARENT,Shader.TileMode.MIRROR));
        canvas.drawCircle(centerX, centerY, outerRadius+value, CirclePaint);//outer Animated circle
        super.onDraw(canvas);
    }

    public void setOuterRadius(int outerRadius) {
        this.outerRadius = outerRadius;
        this.invalidate();
    }

    private int getHighlightColor(int color, int amount) {
        return Color.argb(Math.min(255, Color.alpha(color)), Math.min(255, Color.red(color) + amount),
                Math.min(255, Color.green(color) + amount), Math.min(255, Color.blue(color) + amount));
    }

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if(value==pressedRingWidth){
                value--;
                isretrieving=true;
                //Log.d("runner1", "1");
            }
            else if(isretrieving&&value==0){
               // Log.d("runner1","4");
                isretrieving=false;
            }
            else if(isretrieving){
                value--;
                //Log.d("runner1","3");
            }
            else{
                value++;
                //Log.d("runner1","2");
            }
            invalidate();
            handler.postDelayed(this,50);
        }
    };


    private Handler handler=new Handler();

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        handler.post(runnable);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(runnable);
    }

    public void setPressedRingWidth(int pressedRingWidth) {
        this.pressedRingWidth = pressedRingWidth;
        fixedValueWidth=pressedRingWidth;
        this.invalidate();
    }
}
