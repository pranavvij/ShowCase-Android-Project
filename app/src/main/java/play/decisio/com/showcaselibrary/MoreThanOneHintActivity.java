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
import android.widget.ImageView;

import com.example.pranavvij.showcaselibrary.WooplrShowCaseView;


public class MoreThanOneHintActivity extends ActionBarActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_than_one_hint);
        imageView=(ImageView)findViewById(R.id.user2);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect point= WooplrShowCaseView.locateView(imageView);
                WooplrShowCaseView wooplrShowCaseView=new WooplrShowCaseView(imageView.getWidth(),imageView.getHeight(),MoreThanOneHintActivity.this,getApplicationContext(),getWindow(),point.right,point.bottom);
                wooplrShowCaseView.setText("Hello World",WooplrShowCaseView.TOPRIGHT,getSupportFragmentManager());
                wooplrShowCaseView.setFlipColor(R.color.progress_bar_color);
                wooplrShowCaseView.setBackgroundColor(R.color.black);
                wooplrShowCaseView.setTextColor(R.color.pure_white);
                wooplrShowCaseView.setText("Hey", WooplrShowCaseView.BOTTOMRIGHT, getSupportFragmentManager());
                wooplrShowCaseView.setBackgroundColor(R.color.complementary_blue);
                wooplrShowCaseView.setTextColor(R.color.black);
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
