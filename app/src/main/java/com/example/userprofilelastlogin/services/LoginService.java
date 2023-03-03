package com.example.userprofilelastlogin.services;
import com.example.userprofilelastlogin.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface LoginService {
    @FormUrlEncoded
    @POST("NewApi.php?apicall=login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);
}
