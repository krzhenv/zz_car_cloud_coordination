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

public class AutoPark extends Activity implements View.OnClickListener{

    ImageButton parkout,parkin;
    private Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autopark);
        this.mContext = this;

        parkin=findViewById(R.id.In);
        parkout=findViewById(R.id.Out);
        parkin.setOnClickListener(this);
        parkout.setOnClickListener(this);

    }

    @OnClick({R.id.Out, R.id.In})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Out:
                /**出车*/
                Intent intent1 = new Intent(AutoPark.this, AutoParkOut.class);
                startActivity(intent1);
                break;
            case R.id.In:
                /**泊车*/
                //对话框
                AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                builder.setIcon(R.drawable.shangbackground);
                builder.setTitle("确认泊车");//设置对话框的标题
                builder.setMessage("自动泊车是由云端计算机控制车辆自动泊入车位，该功能有一定风险，一切后果将由车主承担");//设置对话框的内容
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent=new Intent(AutoPark.this, AutoParkingIn.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {  //取消按钮

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(AutoPark.this, "取消成功",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog b=builder.create();
                b.show();

        }
    }
}

