package com.jmconsultant.starter.models.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String token;
    private Credentials credentials;
}
