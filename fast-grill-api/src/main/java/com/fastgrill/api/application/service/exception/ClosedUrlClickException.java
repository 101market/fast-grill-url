package com.fastgrill.api.application.service.exception;


import com.fastgrill.core.common.exception.BaseException;
import com.fastgrill.core.common.exception.ErrorCode;

public class ClosedUrlClickException extends BaseException {
    public ClosedUrlClickException() {
        super(ErrorCode.SHORTEN_URL_CLOSED);
    }
}
