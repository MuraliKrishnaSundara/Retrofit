package com.example.retrofit_i_we;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/api/users/{userId}")
    Call<ResponseModel> getUser(@Path("userId") int userId);
}