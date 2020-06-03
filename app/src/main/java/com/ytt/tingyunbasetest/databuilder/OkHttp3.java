package com.ytt.tingyunbasetest.databuilder;

import android.os.Environment;
import android.util.Log;

import com.ytt.tingyunbasetest.util.LogY;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp3 extends Thread{
    private String url="";
    OkHttpClient client = new OkHttpClient();
    public OkHttp3(String url){
        this.url=url;
    }


    LogY logger=new LogY("OkHttp3");

    //创建一个Request
    public void get(boolean isDownload){
        Request request = new Request.Builder()
                .get()
                .url(this.url)
                .build();
        //通过client发起请求
        logger.msg("start:"+System.currentTimeMillis());
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()) {
                    if(isDownload){
                        //streamReader(response);
                        downloadfile(response, Environment.getExternalStorageDirectory().getAbsolutePath(),"text.png");
                    }
                }

            }
        });
    }
    public void post(String url){
        RequestBody body = new FormBody.Builder().add("username","xiaoyi").build();
        Request request = new Request.Builder()
                .post(body)
                .url(this.url).
                        build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // String str = response.body().string();
                }

            }
        });
    }
    public void download(String url){
        /*读流*/
        get(true);
    }
    private void streamReader(Response response){
        InputStream is = response.body().byteStream();
        if (is != null) {
            byte[] buffer = new byte[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    if (!((len = is.read(buffer)) > 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(len);
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void downloadfile(Response response, String url, String fileName) {
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            //文件大小
            long total = response.body().contentLength();
            File file = new File(url, fileName);
            fos = new FileOutputStream(file);
            long sum = 0;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
//                进度条
//                sum += len;
//                int progress = (int) (sum * 1.0f / total * 100);
            }
            fos.flush();
            Log.e("xxxxxxxx", "下载成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
            }
            logger.msg("end:"+System.currentTimeMillis());
        }
    }

    @Override
    public void run() {
        get(true);
    }
}
