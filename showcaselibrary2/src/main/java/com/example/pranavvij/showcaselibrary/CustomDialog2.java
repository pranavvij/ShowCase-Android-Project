package com.example.pranavvij.showcaselibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CustomDialog2 {
    int positionanim=0;
    int x,y;
    TextView textView;
    int width,height;
    Window window;
    PopupWindow popupWindow;
    Context class_context,context;
    PopupWindow parent;
    CustomDialog2(PopupWindow popupWindow,Context context,Context class_context,Window window,int positionanim,int x,int y,int width,int height) {
        this.positionanim=positionanim;
        this.x=x;
        this.y=y;
        this.window=window;
        this.parent=popupWindow;
        this.class_context=class_context;
        this.context=context;
        this.width=width;
        this.height=height;
        init(context,class_context,window);
    }
    void init(Context context,Context class_context,Window window){
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(class_context.LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.dialog_layout2, null);
        textView=(TextView)popupView.findViewById(R.id.textView);
        popupWindow = new PopupWindow(popupView, RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        popupView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        x=x-popupView.getMeasuredWidth()/2;
        y=y-popupView.getMeasuredHeight()/2;
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                parent.dismiss();
                Log.d("this is ","hello");
                popupWindow.dismiss();
            }
        });
        popupWindow.setAnimationStyle(R.style.dialog_animation_fade_right);
        switch(positionanim) {
            case 3://bottom
                popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT, x , y + popupView.getMeasuredHeight()/2 +parent.getHeight()/2);
                break;
            case 1://left
                popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT, x -(popupView.getMeasuredWidth()/2 +parent.getWidth()/2) , y);
                break;
            case 0://right
                popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT, x + parent.getWidth()/2 + popupView.getMeasuredWidth()/2 , y);
                break;
            case 2://top
                popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT, x, y - (popupView.getMeasuredHeight()/2+parent.getHeight()/2));
                break;
            case 4://bottomright
                popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT,  x + parent.getWidth()/2 + popupView.getMeasuredWidth()/2, y + (popupView.getMeasuredHeight()/2+parent.getHeight()/2));
                break;
            case 5://bottomleft
                popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT, x -(popupView.getMeasuredWidth()/2 +parent.getWidth()/2), y + (popupView.getMeasuredHeight()/2+parent.getHeight()/2));
                break;
            case 6://topright
                popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT, x + parent.getWidth()/2 + popupView.getMeasuredWidth()/2, y - (popupView.getMeasuredHeight()/2+parent.getHeight()/2));
                break;
            case 7://topleft
                popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT, x -(popupView.getMeasuredWidth()/2 +parent.getWidth()/2), y - (popupView.getMeasuredHeight()/2+parent.getHeight()/2));
                break;
        }
    }

    public void setText(String text) {
        textView.setText(text);
    }
    void setColor(int color){
        textView.setTextColor(class_context.getResources().getColor(color));
    }
    public void setBackgroundColor(int color){
        textView.setBackgroundColor(class_context.getResources().getColor(color));
    }
}