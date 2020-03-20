package com.ytt.tingyunbasetest;

import android.app.Application;
import android.content.Context;

import com.ytt.tingyunbasetest.util.Tingyun;

public class yApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Tingyun.initWukong(base);
    }

}
