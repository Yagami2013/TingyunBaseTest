package com.ytt.tingyunbasetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ytt.tingyunbasetest.activity.TestPage;
import com.ytt.tingyunbasetest.databuilder.Trace;
import com.ytt.tingyunbasetest.util.CommonTools;
import com.ytt.tingyunbasetest.util.LogY;
import com.ytt.tingyunbasetest.util.Tingyun;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    LogY logger=new LogY(this.getClass().getSimpleName());
    private String mac;
    //LogY logger=new LogY(this.getLocalClassName());
    /*crash,
    Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String android.content.Context.getPackageName()' on a null object reference
        at android.content.ContextWrapper.getPackageName(ContextWrapper.java:145)
        at android.app.Activity.getLocalClassName
    * */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mac=CommonTools.getMac(getApplicationContext());
        logger.msg("onCreate run...");
        grantPermissions();
        buttonInit();

    }
    void grantPermissions(){
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ACCESS_WIFI_STATE
        },1);
    }
    void buttonInit(){
        final Button goToTestPage=(Button)findViewById(R.id.go_to_test);
        goToTestPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TestPage.class);
                Tingyun.initWukong(v.getContext(),mac);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.msg("onResume run...");
        /*sleep 3s with net,json,sql actions
        * making this activity onPause & onResume
        * */
        Trace.all();

    }

    @Override
    protected void onStart() {
        super.onStart();
        logger.msg("onStart run...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logger.msg("onRestart run...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logger.msg("onPause run...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logger.msg("onDestroy run...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logger.msg("onStop run...");
    }
}
