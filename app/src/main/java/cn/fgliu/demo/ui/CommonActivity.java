package cn.fgliu.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import cn.fgliu.demo.R;

public class CommonActivity extends AppCompatActivity {

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        imageView = (ImageView)findViewById(R.id.glideImg);

        Button but = (Button)findViewById(R.id.loadimgbut);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://image.fanhuan.com/goods/2017-03-21/542846746605.jpg!300.300?v=1490073972";
                setImage(url);
            }
        });

    }

    private void setImage(String url){
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.launcher_icon)
                .error(R.drawable.arrow)
                .override(100,100)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    // For a simple image list:
//    @Override
//    public View getView(int position, View recycled, ViewGroup container) {
//        final ImageView myImageView;
//        if (recycled == null) {
//            myImageView = (ImageView) inflater.inflate(R.layout.loadimgbut, container, false);
//        } else {
//            myImageView = (ImageView) recycled;
//        }
//
//        String url = myUrls.get(position);
//
//        Glide
//                .with(myFragment)
//                .load(url)
//                .centerCrop()
//                .placeholder(R.drawable.loading_spinner)
//                .crossFade()
//                .into(myImageView);
//
//        return myImageView;
//    }
}
