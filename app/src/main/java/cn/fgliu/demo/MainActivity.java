package cn.fgliu.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.fgliu.demo.service.FloatWindowService;
import cn.fgliu.demo.ui.BidirSlidingActivity;
import cn.fgliu.demo.ui.ContactActivity;
import cn.fgliu.demo.ui.DanmuActivity;
import cn.fgliu.demo.ui.FragmentActivity;
import cn.fgliu.demo.ui.FragmentTabActivity;
import cn.fgliu.demo.ui.MsgActivity;
import cn.fgliu.demo.ui.NewWallScrollActivity;
import cn.fgliu.demo.ui.PhotoWallActivity;
import cn.fgliu.demo.ui.PictureActivity;
import cn.fgliu.demo.ui.RefreshActivity;
import cn.fgliu.demo.ui.RenRenMenuActivity;
import cn.fgliu.demo.ui.ScannerActivity;
import cn.fgliu.demo.ui.SliderActivity;
import cn.fgliu.demo.ui.SlidingSwitcherActivity;
import cn.fgliu.demo.ui.ThreeDActivity;
import cn.fgliu.demo.ui.WallScrollActivity;

public class MainActivity extends AppCompatActivity {

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

        // 顶部滚动banner
        Button topMenuWindow = (Button) findViewById(R.id.switch_menu_window);
        topMenuWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, SlidingSwitcherActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 碎片化
        Button frameMenuWindow = (Button) findViewById(R.id.frame_menu_window);
        frameMenuWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 底部菜单，含页签功能(替换ActivityGroup)
        Button tabMenuWindow = (Button) findViewById(R.id.tab_menu_window);
        tabMenuWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, FragmentTabActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 通讯录
        Button contactWindow = (Button) findViewById(R.id.contact_menu_window_button);
        contactWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 下拉刷新
        Button refreshWindow = (Button) findViewById(R.id.refresh_button);
        refreshWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, RefreshActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 照片墙
        Button photoWindow = (Button) findViewById(R.id.photo_wall_button);
        photoWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, PhotoWallActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 聊天页面
        Button chatWindow = (Button) findViewById(R.id.msg_button);
        chatWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, MsgActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 扫描二维码
        Button scanWindow = (Button) findViewById(R.id.scan_window_but);
        scanWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ScannerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 旋转特效
        Button picWindow = (Button) findViewById(R.id.pic_window_but);
        picWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, PictureActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 3D旋转特效
        Button threeDWindow = (Button) findViewById(R.id.three_d_but);
        threeDWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ThreeDActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 瀑布流
        Button wallWindow = (Button) findViewById(R.id.wall_but);
        wallWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, WallScrollActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 加强可滚动瀑布流
        Button scarWallWindow = (Button) findViewById(R.id.scar_wall_but);
        scarWallWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, NewWallScrollActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 弹幕视频
        Button tanmuWindow = (Button) findViewById(R.id.Danmu_but);
        tanmuWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, DanmuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
