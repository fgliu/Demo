package cn.fgliu.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import cn.fgliu.demo.R;

public class WallScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_wall_scroll);
    }
}
