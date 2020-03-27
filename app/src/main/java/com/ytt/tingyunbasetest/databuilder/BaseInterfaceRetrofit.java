package com.ytt.tingyunbasetest.databuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.POST;
import retrofit2.http.PUT;

interface BaseInterfaceRetrofit {
    String uri="/";
    @GET(uri)
    Call<ResponseBody> get();
    @GET(uri)
    Call<ResponseBody> get(String url);
    @POST(uri)
    Call<ResponseBody> post();
    @POST(uri)
    Call<ResponseBody> post(String url);
    @HEAD(uri)
    Call<ResponseBody> head(String url);
    @PUT(uri)
    Call<ResponseBody> put(String url);
    @DELETE(uri)
    Call<ResponseBody> delete(String url);
}
