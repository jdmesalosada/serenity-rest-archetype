package com.jmconsultant.starter.factories;

import com.jmconsultant.starter.models.login.Credentials;
import com.jmconsultant.starter.models.login.LoginRequest;
import com.jmconsultant.starter.models.register.UserRegisterRequest;

public class LoginFactory {

    public static LoginRequest withValidUser(){
        return LoginRequest
                .builder()
                .token("123366666")
                .credentials(Credentials.builder()
                        .username("diegoromerog@subocol.com")
                        .password("$m4T14s#")
                        .build())
                .build();
    }

    public static LoginRequest withInvalidPassword(){
        return LoginRequest
                .builder()
                .token("123366666")
                .credentials(Credentials.builder()
                        .username("diegoromerog@subocol.com")
                        .password("badPassword")
                        .build())
                .build();
    }
}
