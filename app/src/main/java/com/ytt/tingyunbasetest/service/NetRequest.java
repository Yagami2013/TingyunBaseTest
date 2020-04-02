package com.ytt.tingyunbasetest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


import com.ytt.tingyunbasetest.databuilder.Trace;
import com.ytt.tingyunbasetest.util.LogY;


public class NetRequest extends Service {
    LogY logger=new LogY("Service");
    IBinder mBinder;

    @Override
    public IBinder onBind(Intent intent) {
        logger.msg("service onBind");
        return mBinder;
    }

    @Override
    public void onCreate() {
        logger.msg("service onCreate");
        super.onCreate();
        mBinder=new PlayerBinder();
        Trace.all();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        logger.msg("service onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        logger.msg("service onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logger.msg("service onDestroy");
    }
}
