package com.fastgrill.admin.common.response;

import com.fastgrill.core.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private Result result;
    private T data;
    private String message;
    private String errorCode;

    public static <T> Response<T> success(T data, String message) {
        return (Response<T>) Response.builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> Response<T> success(T data) {
        return success(data, null);
    }

    public static Response fail(String message, ErrorCode errorCode) {
        return Response.builder()
                .result(Result.FAIL)
                .message(message)
                .errorCode(errorCode.name())
                .build();
    }

    public static Response fail(ErrorCode errorCode) {
        return Response.builder()
                .result(Result.FAIL)
                .message(errorCode.getMessage())
                .errorCode(errorCode.name())
                .build();
    }

    public enum Result {
        SUCCESS, FAIL
    }
}
