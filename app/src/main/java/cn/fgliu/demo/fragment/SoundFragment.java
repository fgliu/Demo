package cn.fgliu.demo.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.fgliu.demo.R;

/**
 * A simple {@link Fragment} subclass.
 *  * 声音界面的Fragment，加载了sound_fragment布局。
 */
public class SoundFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sound, container, false);
    }

}
