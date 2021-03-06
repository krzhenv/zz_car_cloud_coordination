package com.tencent.iot.hub.device.android.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import androidx.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.tencent.iot.hub.device.android.app.autopark.AutoPark;
import com.tencent.iot.hub.device.android.app.remotecontrol.RemoteControlInitial;
import com.tencent.iot.hub.device.android.app.videomonitoring.VideoMonitor;

import butterknife.OnClick;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton imagebutton_video,imagebutton_prak,imagebutton_call,imagebutton_hand_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        imagebutton_video= findViewById(R.id.video);
        imagebutton_prak = findViewById(R.id.au_park);
        imagebutton_call= findViewById(R.id.call);
        imagebutton_hand_remove= findViewById(R.id.RemoteControl_remove);
        imagebutton_video.setOnClickListener(this);
        imagebutton_prak.setOnClickListener(this);
        imagebutton_call.setOnClickListener(this);
        imagebutton_hand_remove.setOnClickListener(this);
    }


    @OnClick({R.id.video, R.id.au_park, R.id.call,R.id.RemoteControl_remove})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.video:
                /**视频监控*/
                startActivity(VideoMonitor.class);
                break;
            case R.id.RemoteControl_remove:
                /**遥控挪车*/
                startActivity(RemoteControlInitial.class);
                break;
            case R.id.au_park:
                /**自动出泊车*/
                startActivity(AutoPark.class);
                break;

//            case R.id.call:
//                /**叫车*/
//                startActivity(PlayerActivity.class);
//                break;
        }
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }
}
