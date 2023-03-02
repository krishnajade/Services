package com.example.userprofilelastlogin.models;

public class LoginResponse {
    private final String message;
    public LoginResponse(String message) {
        this.message = message;
    }
    public boolean isSuccess() {
        return message.equals("Login successfull") ;
    }
}
