package cn.fgliu.demo.ui;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;

import cn.fgliu.demo.R;

public class ScannerActivity extends AppCompatActivity {
    Camera mCamera = null;
    public static final int SCAN_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        Button button = (Button) findViewById(R.id.scan_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScannerActivity.this, CaptureActivity.class);
                startActivityForResult(intent, SCAN_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SCAN_CODE:
                TextView scanResult = (TextView) findViewById(R.id.scan_result);
                if (resultCode == RESULT_OK) {
                    String result = data.getStringExtra("scan_result");
                    scanResult.setText(result);
                } else if (resultCode == RESULT_CANCELED) {
                    scanResult.setText("扫描出错");
                }
                break;
            default:
                break;
        }
    }

}
