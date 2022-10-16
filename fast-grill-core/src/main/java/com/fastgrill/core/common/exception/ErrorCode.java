package com.fastgrill.core.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
    CLIENT_ABORT(HttpStatus.OK, "사용자에 의하여 요청이 취소되었습니다."),
    INVALID_PARAMETER(HttpStatus.INTERNAL_SERVER_ERROR, "요청한 값이 올바르지 않습니다.")
    ;

    private final HttpStatus status;
    private final String message;
}
