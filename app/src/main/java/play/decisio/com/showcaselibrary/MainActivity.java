package play.decisio.com.showcaselibrary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.pranavvij.showcaselibrary.WooplrShowCaseView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        loadInfoView();
    }



    private void loadInfoView() {
        ArrayList<String> strings=new ArrayList<>();
        strings.add("ImageView Icon Showcase");
        strings.add("Toolbar Icon ShowCase");
        strings.add("Over Another Activity");
        strings.add("More than one TextHint");
        strings.add("Position Any Where TextHint");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapt=new RecyclerAdapter(strings);
        adapt.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,ImageViewIconShowcase.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,ToolbarIconshowCase.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,overAnotherActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,MoreThanOneHintActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,AnyWhereHintActivity.class));
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapt);
    }
}
