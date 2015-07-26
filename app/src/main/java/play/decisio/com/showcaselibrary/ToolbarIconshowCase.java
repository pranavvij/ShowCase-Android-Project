package play.decisio.com.showcaselibrary;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.example.pranavvij.showcaselibrary.WooplrShowCaseView;


public class ToolbarIconshowCase extends ActionBarActivity {
    Toolbar toolbar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_iconshow_case);
        imageView=(ImageView)findViewById(R.id.back);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect point= WooplrShowCaseView.locateView(imageView);
                WooplrShowCaseView wooplrShowCaseView=new WooplrShowCaseView(imageView.getWidth(),imageView.getHeight(),ToolbarIconshowCase.this,getApplicationContext(),getWindow(),point.right,point.bottom);
                wooplrShowCaseView.setFlipColor(R.color.black);
                wooplrShowCaseView.setText("Hello World",WooplrShowCaseView.BOTTOMRIGHT,getSupportFragmentManager());
                wooplrShowCaseView.setTextColor(R.color.black);
                wooplrShowCaseView.setBackgroundColor(R.color.white);
                removeOnGlobalLayoutListener(imageView,this);
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
