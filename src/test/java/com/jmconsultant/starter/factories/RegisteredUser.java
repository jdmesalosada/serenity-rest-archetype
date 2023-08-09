package com.jmconsultant.starter.factories;

import com.jmconsultant.starter.models.register.UserRegisterRequest;

public class RegisteredUser {
    public static UserRegisterRequest noRegisteredUser(){
        return UserRegisterRequest
                .builder()
                .email("juan")
                .password("pistol")
                .build();
    }
}
