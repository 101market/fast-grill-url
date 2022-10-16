package com.fastgrill.api.common.response;

import com.fastgrill.api.common.interceptor.CommonHttpRequestInterceptor;
import com.fastgrill.core.common.exception.BaseException;
import com.fastgrill.core.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.jboss.logging.MDC;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> onException(Exception e) {
        String eventId = (String) MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
        log.error("eventId = {} ", eventId, e);

        return ResponseEntity.status(ErrorCode.SYSTEM_ERROR.getStatus())
                .body(Response.fail(ErrorCode.SYSTEM_ERROR));
    }

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<?> onBaseException(BaseException e) {
        String eventId = (String) MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
        log.error("[BaseException] eventId = {}, cause = {}, errorMsg = {}", eventId, NestedExceptionUtils.getMostSpecificCause(e), NestedExceptionUtils.getMostSpecificCause(e).getMessage());
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(Response.fail(e.getErrorCode()));
    }

    @ExceptionHandler(ClientAbortException.class)
    public ResponseEntity<?> skipException(Exception e) {
        String eventId = (String) MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
        log.warn("[skipException] eventId = {}, cause = {}, errorMsg = {}", eventId, NestedExceptionUtils.getMostSpecificCause(e), NestedExceptionUtils.getMostSpecificCause(e).getMessage());
        return ResponseEntity.status(ErrorCode.CLIENT_ABORT.getStatus())
                .body(Response.fail(ErrorCode.CLIENT_ABORT));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String eventId = (String) MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
        log.warn("[BaseException] eventId = {}, errorMsg = {}", eventId, NestedExceptionUtils.getMostSpecificCause(e).getMessage());
        BindingResult bindingResult = e.getBindingResult();
        FieldError fe = bindingResult.getFieldError();
        if (fe != null) {
            String message = "Request Error" + " " + fe.getField() + "=" + fe.getRejectedValue() + " (" + fe.getDefaultMessage() + ")";
            return ResponseEntity.status(ErrorCode.INVALID_PARAMETER.getStatus())
                    .body(Response.fail(message, ErrorCode.INVALID_PARAMETER));
        } else {
            return ResponseEntity.status(ErrorCode.INVALID_PARAMETER.getStatus())
                    .body(Response.fail(ErrorCode.INVALID_PARAMETER));
        }
    }
}
