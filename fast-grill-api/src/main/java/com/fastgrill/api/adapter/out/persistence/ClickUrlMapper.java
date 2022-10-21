package com.fastgrill.api.adapter.out.persistence;

import com.fastgrill.api.domain.ClickThresholdContract;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class ClickUrlMapper {
    //    TODO: map struct으로 교체하자
    public ClickUrl mapToDomainEntity(ShortenUrlJpaEntity shortenUrl) {
        ClickThresholdContract thresholdContract = new ClickThresholdContract(
                shortenUrl.getExpiredAt(),
                shortenUrl.getThresholdRequestCount()
        );
        return new ClickUrl(shortenUrl.getOriginUrl(), shortenUrl.getShortenToken(), shortenUrl.isEnable(), thresholdContract);
    }
}
