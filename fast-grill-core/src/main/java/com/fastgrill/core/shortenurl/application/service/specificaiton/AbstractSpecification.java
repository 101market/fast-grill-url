package com.fastgrill.core.shortenurl.application.service.specificaiton;

import com.fastgrill.core.common.exception.BaseException;

public abstract class AbstractSpecification<T> implements Specification<T> {

    public abstract boolean isSatisfiedBy(T t);

    public abstract void check(T t) throws BaseException;

    public Specification<T> and(final Specification<T> specification) {
        return new AndSpecification<T>(this, specification);
    }
}
