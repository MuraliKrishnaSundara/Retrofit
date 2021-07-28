package com.example.uploadvideoretrofit;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    @Headers("Authorization: Client-ID b9cb6dfe374fea1")
    @POST("3/video")
    @Multipart
    Call<ResponseDTO> uploadVideo(
            @Part MultipartBody.Part file,
            @Part("tittle") String title
    );
}