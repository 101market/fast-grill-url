package com.fastgrill.core.shortenurl.application.service.specificaiton;

public interface Specification<T> {

    boolean isSatisfiedBy(T t);

    Specification<T> and(Specification<T> specification);
}