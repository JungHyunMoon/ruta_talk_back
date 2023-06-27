package com.rutatalk.infra.entity.enums;

import com.rutatalk.exception.CustomExceptionDto;
import com.rutatalk.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response<T> {

    private String resultCode;
    private T result;

    public static Response error(CustomException e) {
        return new Response<>("ERROR", CustomExceptionDto.of(e));
    }

    public static <T> Response<T> success(T resultObject) {
        return new Response<>("SUCCESS", resultObject);
    }
}

