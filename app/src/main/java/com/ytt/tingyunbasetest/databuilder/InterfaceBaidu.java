package com.ytt.tingyunbasetest.databuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceBaidu {
    String uri="act/newpneumonia/newpneumonia/";
    @GET(uri)
    Call<ResponseBody> getNews(@Query("from") String from);

}
