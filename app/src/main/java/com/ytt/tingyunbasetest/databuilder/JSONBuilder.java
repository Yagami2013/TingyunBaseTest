package com.ytt.tingyunbasetest.databuilder;

import android.util.Log;

import com.ytt.tingyunbasetest.util.CommonTools;
import com.ytt.tingyunbasetest.util.LogY;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class JSONBuilder {
    /*给log tag加上类名*/
    LogY logger=new LogY(this.getClass().getSimpleName());

    /*
    输入字符串，打印所有的key，如果有type,打印type值
    */
    public void test(String str){
        if(str==null||"".equals(str)){
            logger.warning("空字符串，JSONBuilder停止解析");
            return;
        }

        JSONObject o= null;
        try {
            o = new JSONObject(str);
            logger.msg(o.names().toString());
            if (o.has("type")){
                logger.msg(o.getString("type"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            logger.err(e.getStackTrace());
        }
    }
    public void test(File f){
        String string = CommonTools.readFile(f);
        this.test(string);
    }
    /*判断是否json*/
    public boolean isJson(String content){
        try {
            JSONObject jsonStr= new JSONObject(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
