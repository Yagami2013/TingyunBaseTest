package com.ytt.tingyunbasetest.databuilder;

import com.ytt.tingyunbasetest.util.LogY;
import com.ytt.tingyunbasetest.util.Tingyun;

import java.io.File;

public class Trace {
    static LogY logger=new LogY(Trace.class.getSimpleName());
    public static void getJSON(){
        JSONBuilder builder=new JSONBuilder();
        String str="{\"type\":\"userActions\",\"interval\":60,\"timestamp\":1584085217,\"dev\":[\"\",1,\"WIFI\",0.0,0.0,\"\"],\"actions\":[[0,\"yangtt.personal.testjni_saas.AC_ANR#conflictPrinter\",5175,5011,2,1,1,0,1,\"{\\\"pt\\\":\\\"Qualcomm Technologies, Inc MSM8996\\\",\\\"arch\\\":\\\"arm64-v8a\\\",\\\"pu\\\":0,\\\"mem\\\":1305,\\\"sp\\\":33181,\\\"sd\\\":33181,\\\"pwr\\\":83,\\\"jb\\\":1,\\\"orui\\\":0,\\\"cust\\\":{\\\"name\\\":\\\"yangtt\\\",\\\"number\\\":\\\"123456789000000000000000000000000000000000\\\",\\\"anrMsg\\\":\\\"CustomAnrAdditionalMessage\\\"}}\",\"{\\\"cpu\\\":[],\\\"mem\\\":[],\\\"stacks\\\":[0,0,5007,\\\"yangtt.personal.testjni_saas.AC_ANR#conflictPrinter\\\",0,1,[2,\\\"main\\\"],{},[[7,7,5174,\\\"URLConnection\\\",1,2,[4200,\\\"Thread-23\\\"],{\\\"host\\\":\\\"192.168.2.41\\\",\\\"url\\\":\\\"http://192.168.2.41:8080/External_01/\\\",\\\"httpStatus\\\":903,\\\"errorCode\\\":903,\\\"bytesSent\\\":0,\\\"bytesReceived\\\":0,\\\"dns\\\":-1,\\\"conn\\\":-1,\\\"fp\\\":-1,\\\"ssl\\\":-1,\\\"txData\\\":null,\\\"txDataNew\\\":\\\"\\\"},[],0]],0]}\"]]}";
        builder.test(str);
        builder.test(new File("/sdcard/testfile.txt"));
    }
    public static void getSQL(){
        SQLBuilder builder=new SQLBuilder();
        builder.createTable();
        builder.insert("Jim","10014");
        builder.search();
    }
    public static void all(){
        getNet();
        getBitMap();
        getJSON();
        getSQL();
        getCustom();
    }

    public static void getCustom() {
        Tingyun.sleepWithCustomTrace(3);
    }

    public static void getBitMap() {
        //todo:BitMap Builder
    }
    public static void getANR(){}

    public static void getCrash(){
        all();
        int a=Integer.MAX_VALUE;
        int b=0;
        //int b=a;
        //int result=plus(a,b);
        //result=-2,don't crash
        logger.msg("a:"+a);
        logger.msg("b:"+b);
        logger.msg("a+b:"+a/b);
    }
    public static int plus(int a,int b){
        return a+b;
    }

    public static void getNet() {
        //todo:use retrofit,OK3,HttpUrlConnection to start requests
        RetrofitBuilder builder=new RetrofitBuilder();
        builder.get_async();
        RetrofitBuilder.get("https://github.com/");
        RetrofitBuilder.get("http://192.168.");
    }

    public static native String getKey();

}
