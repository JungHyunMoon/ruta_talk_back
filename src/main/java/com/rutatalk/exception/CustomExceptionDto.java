package com.rutatalk.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomExceptionDto {

    private String errorCode;
    private String message;

    public static CustomExceptionDto of(CustomException e) {
        return new CustomExceptionDto(e.getErrorCode().name(), e.getMessage());
    }
}