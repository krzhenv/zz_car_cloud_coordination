package com.tencent.iot.hub.device.android.app.videomonitoring;

import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ShowMyToast {
    public void showMyToast(final Toast toast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt );
    }
}
