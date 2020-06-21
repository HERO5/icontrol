package com.mrl.icontrol.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.mrl.network.echo.EchoServer;
import com.mrl.network.protobuf.NettyServer;

/**
 * Created by user on 2016/10/27.
 */

public class ServerService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        NettyServer.getInstance().init();
        EchoServer.getInstance(8080);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        NettyServer.getInstance().shutDown();
    }
}
