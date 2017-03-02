package cn.fgliu.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.fgliu.demo.service.FloatWindowService;
import cn.fgliu.demo.ui.BidirSlidingActivity;
import cn.fgliu.demo.ui.RenRenMenuActivity;
import cn.fgliu.demo.ui.SliderActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 类似360弹窗的按钮
        Button startFloatWindow = (Button) findViewById(R.id.start_float_window);
        startFloatWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, FloatWindowService.class);
                startService(intent);
                finish();
            }
        });

        // 类似人人滑动菜单
        Button renrenMenuWindow = (Button) findViewById(R.id.renren_menu_window);
        renrenMenuWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, RenRenMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 通用滑动菜单
        Button sliderMenuWindow = (Button) findViewById(R.id.slider_menu_window);
        sliderMenuWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, SliderActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 双向滑动菜单
        Button bothMenuWindow = (Button) findViewById(R.id.both_menu_window);
        bothMenuWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, BidirSlidingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}