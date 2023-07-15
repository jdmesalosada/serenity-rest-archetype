package com.jmconsultant.starter.factories;

import com.jmconsultant.starter.models.register.UserRegisterRequest;

public class RegisteredUser {
    public static UserRegisterRequest withDefaultInfo(){
        return UserRegisterRequest
                .builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
    }
}
