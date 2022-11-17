package com.fastgrill.api.application.service.specification;

import com.fastgrill.api.application.service.exception.ClosedUrlClickException;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.common.DomainComponent;
import com.fastgrill.core.shortenurl.application.service.specificaiton.AbstractSpecification;


@DomainComponent
public class EnableUrlClickSpecificationImpl extends AbstractSpecification<ClickUrl> {
    @Override
    public boolean isSatisfiedBy(ClickUrl clickUrl) {
        return clickUrl.isEnable() && !clickUrl.isExpired();
    }

    @Override
    public void check(ClickUrl clickUrl) throws ClosedUrlClickException {
        if (isSatisfiedBy(clickUrl)) return;
        throw new ClosedUrlClickException();
    }
}
