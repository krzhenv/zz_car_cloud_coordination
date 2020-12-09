package com.tencent.iot.hub.device.android.app.autopark;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.iot.hub.device.android.app.R;

public class AutoParkingOut extends Activity {

    private Button pause;
    private int flag = 0 ;
    private TextView outputfield,toptext ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_parking_out);

        pause= (Button)findViewById(R.id.Pause);
        outputfield = findViewById(R.id.Outputfield);
        toptext = findViewById(R.id.Toptext);

        outputfield.setMovementMethod(ScrollingMovementMethod.getInstance());
        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if(flag==0) {
                    pause.setBackgroundColor(Color.RED);
                    toptext.setText("暂停中");
                    toptext.setTextColor(Color.RED);
                    flag = 1 ;
                    refreshLogView( "\n暂停中..." );
                }else{
                    pause.setBackgroundColor(Color.WHITE);
                    toptext.setText("正在泊出车位");
                    toptext.setTextColor(Color.BLACK);
                    flag = 0;
                    refreshLogView( "\n继续泊出..." );

                }
            }
        });

    }

    //更新输出消息框
    private void refreshLogView(String msg){
        outputfield.append(msg);
        int scrollAmount = outputfield.getLayout().getLineTop(outputfield.getLineCount())
                - outputfield.getHeight();
        if (scrollAmount > 0)
            outputfield.scrollTo(0, scrollAmount);
        else
            outputfield.scrollTo(0, 0);
    }
    
}