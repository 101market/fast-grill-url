package com.fast.grill.click.application.service.validator;

import com.fast.grill.click.application.service.ClickValidator;
import com.fast.grill.click.application.service.exception.ClosedUrlClickException;
import com.fast.grill.click.domain.ClickUrl;
import com.fast.grill.common.UseCase;

@UseCase
public class ThresholdClickValidatorImpl implements ClickValidator {
    @Override
    public void validate(ClickUrl clickUrl) {
        if (clickUrl.isExpired()) {
//            TODO: 로그 남기기
            throw new ClosedUrlClickException();
        }

//        todo: 실제 누적 count 조회 (cache+table으로 교체)
        var accumulatedRequestCount = 0L;
        if (clickUrl.isExceedThresholdCount(accumulatedRequestCount)){
            throw new ClosedUrlClickException();
////        todo: 로그 남기기
        }
    }
}
