package com.rutatalk.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginResponse {
    private String jwt;
    private String refreshToken;
}
