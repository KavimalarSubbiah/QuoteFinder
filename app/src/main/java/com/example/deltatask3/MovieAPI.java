package com.example.deltatask3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieAPI {
    //https://run.mocky.io/     v3/8205ce05-5ac2-4801-8afd-0f190f4f136c
    @GET("quotes?limit=2043")
    Call<JSONResponse> getData();
}
