package com.example.userprofilelastlogin.services;

import com.example.userprofilelastlogin.models.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SignupApi {
    @FormUrlEncoded
    @POST("NewApi.php?apicall=signup")
    Call<SignupResponse> signup(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("gender") String gender
    );
}
