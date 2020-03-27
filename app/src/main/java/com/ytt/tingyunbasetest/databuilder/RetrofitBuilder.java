package com.ytt.tingyunbasetest.databuilder;

import com.ytt.tingyunbasetest.util.LogY;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitBuilder {
    private static LogY logger=new LogY("RetrofitBuilder");
    private String host="https://voice.baidu.com/";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(host)
            .build();
    private InterfaceBaidu request=retrofit.create(InterfaceBaidu.class);
    public void get_async(){
        Call<ResponseBody> call=request.getNews("osari_pc_1");
        call=request.getNews("osari_pc_1#tab4");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                logger.msg("Response code:"+response.code());
                logger.msg("Response size:"+response.body().contentLength());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                logger.msg(t.getCause().toString());
            }
        });
    }
    public static void get(String host){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .build();
        BaseInterfaceRetrofit request=retrofit.create(BaseInterfaceRetrofit.class);
        Call<ResponseBody> call=request.get();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                logger.msg("Response code:"+response.code());
                logger.msg("Response size:"+response.body().contentLength());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if(t==null||t.getCause()==null){
                    logger.msg("unknown error");
                }else {
                    logger.msg(t.getCause().toString());
                }

            }
        });
    }

}
