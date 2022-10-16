package com.fastgrill.core.click.application.service;

import com.fastgrill.core.click.domain.ClickUrl;

// TODO: 헥사고날에서 service에서만 사용되는 validator가 service에 위치하는게 적합한지 찾아보기
public interface ClickValidator {
    void validate(ClickUrl clickUrl);
}
