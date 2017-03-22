package cn.fgliu.demo.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.fgliu.demo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

//        msg_but = (Button)view.findViewById(R.id.send_msg_but);
//        msg_but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Activity act = getActivity();
//                Context context = act.getApplicationContext();
//                NotificationManager manager = (NotificationManager) act.getSystemService(NOTIFICATION_SERVICE);
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
//                Notification notification = builder
//                        .setContentTitle("这是通知标题")
//                        .setContentText("这是通知内容")
//                        .setWhen(System.currentTimeMillis())
//                        .setSmallIcon(R.drawable.ic_launcher)
//                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
//                        .build();
//                manager.notify(1, notification);
//            }
//        });
        return view;
    }



}
