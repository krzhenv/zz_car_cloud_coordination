package com.tencent.iot.hub.device.android.app.autopark;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tencent.iot.hub.device.android.app.R;

import butterknife.OnClick;

public class HalfOut extends Activity implements View.OnClickListener{

    private Context mContext;
    ImageButton leftforward,forwardahead,rightforward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half_out);
        this.mContext = this;

        leftforward=findViewById(R.id.Leftforward);
        forwardahead=findViewById(R.id.Forwardahead);
        rightforward=findViewById(R.id.Rightforward);
        leftforward.setOnClickListener(this);
        forwardahead.setOnClickListener(this);
        rightforward.setOnClickListener(this);

        //返回键
        findViewById(R.id.back3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                finish();
            }
        });

    }

    @OnClick({R.id.Leftforward, R.id.Forwardahead,R.id.Rightforward})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Leftforward:
                /**半出车*/
            case R.id.Forwardahead:
                /**完全出车*/
            case R.id.Rightforward:
                /**完全出车*/
                //对话框
                AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                builder.setIcon(R.drawable.shangbackground);
                builder.setTitle("确认出车");//设置对话框的标题
                builder.setMessage("自动出车是由云端计算机控制车辆自动泊出车位，该功能有一定风险，一切后果将由车主承担泊出车位后，车主应尽快接受车辆以避免影响交通");//设置对话框的内容
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent=new Intent(HalfOut.this,AutoParkingOut.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {  //取消按钮

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(HalfOut.this, "取消成功",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog b=builder.create();
                b.show();
                break;


        }
    }
}