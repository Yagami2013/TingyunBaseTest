package com.ytt.tingyunbasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ytt.tingyunbasetest.databuilder.JSONBuilder;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONBuilder builder=new JSONBuilder();
        String str="{\"type\":\"userActions\",\"interval\":60,\"timestamp\":1584085217,\"dev\":[\"\",1,\"WIFI\",0.0,0.0,\"\"],\"actions\":[[0,\"yangtt.personal.testjni_saas.AC_ANR#conflictPrinter\",5175,5011,2,1,1,0,1,\"{\\\"pt\\\":\\\"Qualcomm Technologies, Inc MSM8996\\\",\\\"arch\\\":\\\"arm64-v8a\\\",\\\"pu\\\":0,\\\"mem\\\":1305,\\\"sp\\\":33181,\\\"sd\\\":33181,\\\"pwr\\\":83,\\\"jb\\\":1,\\\"orui\\\":0,\\\"cust\\\":{\\\"name\\\":\\\"yangtt\\\",\\\"number\\\":\\\"123456789000000000000000000000000000000000\\\",\\\"anrMsg\\\":\\\"CustomAnrAdditionalMessage\\\"}}\",\"{\\\"cpu\\\":[],\\\"mem\\\":[],\\\"stacks\\\":[0,0,5007,\\\"yangtt.personal.testjni_saas.AC_ANR#conflictPrinter\\\",0,1,[2,\\\"main\\\"],{},[[7,7,5174,\\\"URLConnection\\\",1,2,[4200,\\\"Thread-23\\\"],{\\\"host\\\":\\\"192.168.2.41\\\",\\\"url\\\":\\\"http://192.168.2.41:8080/External_01/\\\",\\\"httpStatus\\\":903,\\\"errorCode\\\":903,\\\"bytesSent\\\":0,\\\"bytesReceived\\\":0,\\\"dns\\\":-1,\\\"conn\\\":-1,\\\"fp\\\":-1,\\\"ssl\\\":-1,\\\"txData\\\":null,\\\"txDataNew\\\":\\\"\\\"},[],0]],0]}\"]]}";
        builder.test(str);
        builder.test(new File("/sdcard/testfile.txt"));
    }
}
