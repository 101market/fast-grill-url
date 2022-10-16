package com.fastgrill.core.shortenurl.application.service.validator;

import com.fastgrill.core.shortenurl.application.service.exception.ClosedUrlClickException;
import com.fastgrill.core.shortenurl.application.service.ClickValidator;
import com.fastgrill.core.shortenurl.domain.ClickUrl;
import com.fastgrill.core.common.UseCase;


@UseCase
public class EnableUrlClickValidatorImpl implements ClickValidator {
    @Override
    public void validate(ClickUrl clickUrl) {
        if (clickUrl.isEnable()) return;
        //        todo: 로그 남기기
        throw new ClosedUrlClickException();
    }
}
