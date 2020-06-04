package com.ytt.tingyunbasetest.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;

public class CommonTools {
    public static LogY logger=new LogY("CommonTools");
    public static String readFile(File f){
        String string = "";
        if(f.exists()){
            if(!f.isDirectory()){
                String tmp;
                try {
                    BufferedReader reader=new BufferedReader(new FileReader(f));
                    while ((tmp=reader.readLine())!=null){
                        //logger.msg(tmp);
                        string=string.concat(tmp).concat("\n");
                        //logger.msg(string);
                    }
                    reader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                logger.warning(f.getName()+" is not a file");
            }
        }else {
            logger.warning(f.getName()+" not exist");
        }
        //int l=string.length();
        //logger.warning("str length:"+l+";str end with"+string.charAt(l-2));
        logger.msg(string);
        return string;
    }
    public static void wait(int second_count){
        try {
            Thread.sleep(second_count*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void alert(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
    /**
     * 获取mac地址（适配所有Android版本）
     * @return
     */
    public static String getMac(Context context){
        String mac = "";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            mac = getMacDefault(context);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mac = getMacAddress();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mac = getMacFromHardware();
        }
        return mac;
    }

    private static String getMacAddress() {
        String macSerial = null;
        String str = "";

        try {
            Process pp = Runtime.getRuntime().exec("cat/sys/class/net/wlan0/address");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            while (null != str) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();//去空格
                    break;
                }
            }
        } catch (IOException ex) {
            // 赋予默认值
            ex.printStackTrace();
        }

        return macSerial;
    }
    private static String getMacFromHardware(){
        /**
         * Android 7.0之后获取Mac地址
         * 遍历循环所有的网络接口，找到接口是 wlan0
         * 必须的权限 <uses-permission android:name="android.permission.INTERNET"></uses-permission>
         * @return
         */
            try {

                ArrayList<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
                for (NetworkInterface nif : all) {
                    if (!nif.getName().equals("wlan0"))
                        continue;
                    byte[] macBytes= nif.getHardwareAddress();
                    if (macBytes == null) return "";
                    StringBuilder res1 = new StringBuilder();
                    for (Byte b : macBytes) {
                        res1.append(String.format("%02X:", b));
                    }
                    if (!TextUtils.isEmpty(res1)) {
                        res1.deleteCharAt(res1.length() - 1);
                    }
                    return res1.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "";

    }

    private static String getMacDefault(Context context){
        String mac = "";
        if (context == null) {
            return mac;
        }
        WifiManager wifi = (WifiManager)context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = null;
        try {
            info = wifi.getConnectionInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (info == null) {
            return null;
        }
        mac = info.getMacAddress();
        if (!TextUtils.isEmpty(mac)) {
            mac = mac.toUpperCase(Locale.ENGLISH);
        }
        return mac;
    }
}
