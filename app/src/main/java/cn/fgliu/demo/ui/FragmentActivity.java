package cn.fgliu.demo.ui;

import android.os.Bundle;
import android.app.Activity;

import cn.fgliu.demo.R;

public class FragmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

}
