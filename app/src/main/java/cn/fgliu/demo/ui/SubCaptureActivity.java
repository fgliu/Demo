package cn.fgliu.demo.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;

public class SubCaptureActivity extends CaptureActivity {

    @Override
    public void handleDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        String result = rawResult.getText();
        if (!TextUtils.isEmpty(result)) {
            Intent intent = new Intent();
            intent.putExtra("scan_result", rawResult.getText());
            setResult(RESULT_OK, intent);
        } else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }

}
