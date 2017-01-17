package com.huxq17.example.floatball;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.huxq17.example.floatball.interfaces.IMenu;

public class MainActivity extends Activity {
    private FloatBall mFloatBall;

    public void changeOrientation(View v) {
        if (Utils.isScreenOriatationPortrait(this)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IMenu menu = new FloatBallArcMenu();
//        IMenu menu = new FloatBallMenu();
        FloatBall.SingleIcon singleIcon = new FloatBall.SingleIcon(R.drawable.floatball2, 1f, 0.3f);
        FloatBall.DoubleIcon doubleIcon = new FloatBall.DoubleIcon(R.drawable.floatball2, R.drawable.floatball1);
        //两种状态两张图片的两种写法
//        mFloatBall = new FloatBall.Builder(getApplicationContext()).menu(menu).doubleIcon(doubleIcon).build();
//        mFloatBall = new FloatBall.Builder(getApplicationContext()).menu(menu).icon(singleIcon).doubleIcon(doubleIcon).build();
        //一张图片两种状态的两种写法
//        mFloatBall = new FloatBall.Builder(getApplicationContext()).menu(menu).doubleIcon(doubleIcon).icon(singleIcon).build();
        mFloatBall = new FloatBall.Builder(getApplicationContext()).menu(menu).icon(singleIcon).build();
        //没有菜单的写法
//        mFloatBall = new FloatBall.Builder(getApplicationContext()).icon(singleIcon).build();
        mFloatBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
//        mFloatBall = (FloatBall) LayoutInflater.from(this).inflate(R.layout.float_layout, null);
        mFloatBall.setLayoutGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
    }

    @Override
    protected void onStart() {
        super.onStart();
        show();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        dismiss();
    }

    private void show() {
        mFloatBall.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismiss();
    }

    private void dismiss() {
        mFloatBall.dismiss();
    }

}
