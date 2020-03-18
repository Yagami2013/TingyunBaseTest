package com.ytt.tingyunbasetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ytt.tingyunbasetest.activity.TestPage;
import com.ytt.tingyunbasetest.databuilder.JSONBuilder;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grantPermissions();
        buttonInit();

    }
    void grantPermissions(){
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE
        },1);
    }
    void buttonInit(){
        final Button goToTestPage=(Button)findViewById(R.id.go_to_test);
        goToTestPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TestPage.class);
                startActivity(intent);
            }
        });
    }
}
