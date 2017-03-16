package cn.fgliu.demo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.fgliu.demo.R;

/**
 * Created by andy on 16/03/2017.
 */

public class RocketLauncher extends LinearLayout {

    /**
     * 记录火箭发射台的宽度
     */
    public static int width;

    /**
     * 记录火箭发射台的高度
     */
    public static int height;

    /**
     * 火箭发射台的背景图片
     */
    private ImageView launcherImg;

    public RocketLauncher(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.launcher, this);
        launcherImg = (ImageView) findViewById(R.id.launcher_img);
        width = launcherImg.getLayoutParams().width;
        height = launcherImg.getLayoutParams().height;
    }

    /**
     * 更新火箭发射台的显示状态。如果小火箭被拖到火箭发射台上，就显示发射。
     */
    public void updateLauncherStatus(boolean isReadyToLaunch) {
        if (isReadyToLaunch) {
            launcherImg.setImageResource(R.drawable.launcher_bg_fire);
        } else {
            launcherImg.setImageResource(R.drawable.launcher_bg_hold);
        }
    }
}
