package com.ytt.tingyunbasetest.databuilder;

import com.ytt.tingyunbasetest.util.LogY;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitBuilder {
    private LogY logger=new LogY(this.getClass().getSimpleName());
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://voice.baidu.com/")
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

}
