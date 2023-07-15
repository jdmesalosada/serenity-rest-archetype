package com.jmconsultant.starter.models.register;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterRequest {
    private String email;
    private String password;
}
