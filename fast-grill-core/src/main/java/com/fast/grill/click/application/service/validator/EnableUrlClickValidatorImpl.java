package com.fast.grill.click.application.service.validator;

import com.fast.grill.click.application.service.exception.ClosedUrlClickException;
import com.fast.grill.click.application.service.ClickValidator;
import com.fast.grill.click.domain.ClickUrl;
import com.fast.grill.common.UseCase;


@UseCase
public class EnableUrlClickValidatorImpl implements ClickValidator {
    @Override
    public void validate(ClickUrl clickUrl) {
        if (clickUrl.isEnable()) return;
        //        todo: 로그 남기기
        throw new ClosedUrlClickException();
    }
}
