package play.decisio.com.showcaselibrary;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.example.pranavvij.showcaselibrary.WooplrShowCaseView;


public class TransparentAactivity extends ActionBarActivity {
    RelativeLayout relativeLayout;
    int width;
    int height;
    int right;
    int bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_aactivity);
        width=getIntent().getIntExtra("width",0);
        height=getIntent().getIntExtra("height",0);
        right=getIntent().getIntExtra("right", 0);
        bottom=getIntent().getIntExtra("bottom", 0);
        relativeLayout=(RelativeLayout)findViewById(R.id.relative);
        relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                WooplrShowCaseView wooplrShowCaseView = new WooplrShowCaseView(width, height, TransparentAactivity.this, getApplicationContext(), getWindow(), right, bottom);
                wooplrShowCaseView.setFlipColor(R.color.primary_dark_red);
                wooplrShowCaseView.setText("Hello World", WooplrShowCaseView.TOPRIGHT, getSupportFragmentManager());
                wooplrShowCaseView.setBackgroundColor(R.color.red_light);
                removeOnGlobalLayoutListener(relativeLayout,this);
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void removeOnGlobalLayoutListener(View v, ViewTreeObserver.OnGlobalLayoutListener listener){
        if (Build.VERSION.SDK_INT < 16) {
            v.getViewTreeObserver().removeGlobalOnLayoutListener(listener);
        } else {
            v.getViewTreeObserver().removeOnGlobalLayoutListener(listener);
        }
    }
}
