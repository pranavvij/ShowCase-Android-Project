package com.example.pranavvij.showcaselibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;


public class WooplrShowCaseView  {
    Window window;
    Context context;
    CustomDialog2 dialog2;
    int width,height;
    PopupWindow popupWindow;
    FlipImage image;
    Context class_context;
    public static  int RIGHT=0;
    public static int LEFT=1;
    public static int TOP=2;
    public static int BOTTOM=3;
    public static  int TOPRIGHT=6;
    public static int TOPLEFT=7;
    public static int BOTTOMRIGHT=4;
    public static int BOTTOMLEFT=5;
    int x,y;
    public WooplrShowCaseView(int width,int height,Context class_context, Context context, Window window,int x,int y){
        this.class_context=class_context;
        this.context=context;
        this.window=window;
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
        init(context,class_context,window);
    }
    void init(Context context,Context class_context,Window window){
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(class_context.LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.dialog_layout, null);
        popupWindow = new PopupWindow(popupView,Math.max(width,height),Math.max(width,height));
        image=(FlipImage)popupView.findViewById(R.id.popper);
        image.setOuterRadius(Math.max(width - 20, height - 20) / 2);
        //popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.showAtLocation(window.getDecorView().getRootView(), Gravity.TOP | Gravity.LEFT, x - popupWindow.getWidth() / 2, y - popupWindow.getHeight() / 2);
    }
    public void setFlipColor(int color){
        image.setColor(class_context.getResources().getColor(color));
    }

    public void setText(String text, int direction, FragmentManager manager){
        dialog2=new CustomDialog2(popupWindow,context,class_context,window,direction,x,y,width,height);
        dialog2.setText(text);
    }
    public void setTextColor(int color){
        if(dialog2!=null){
            dialog2.setColor(color);
        }
    }
    public void setBackgroundColor(int color){
        if(dialog2!=null){
            dialog2.setBackgroundColor(color);
        }
    }
    public static Rect locateView(View v)
    {
        int[] loc_int = new int[2];
        if (v == null) return null;
        try
        {
            v.getLocationOnScreen(loc_int);
        } catch (NullPointerException npe)
        {
            //Happens when the view doesn't exist on screen anymore.
            return null;
        }
        Rect location = new Rect();
        location.left = loc_int[0];
        location.top = loc_int[1];
        location.right = location.left + v.getWidth()/2;
        location.bottom = location.top + v.getHeight()/2;
        return location;
    }
}
