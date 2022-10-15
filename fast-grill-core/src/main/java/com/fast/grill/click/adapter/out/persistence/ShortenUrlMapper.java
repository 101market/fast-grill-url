package com.fast.grill.click.adapter.out.persistence;

import com.fast.grill.click.domain.ClickThresholdContract;
import com.fast.grill.click.domain.ClickUrl;
import org.springframework.stereotype.Component;

@Component
public class ShortenUrlMapper {
    //    TODO: map struct으로 교체하자
    public ClickUrl mapToDomainEntity(ShortenUrlJpaEntity shortenUrl) {
        ClickThresholdContract thresholdContract = new ClickThresholdContract(
                shortenUrl.getExpiredAt(),
                shortenUrl.getThresholdRequestCount()
        );
        return new ClickUrl(shortenUrl.getOriginUrl(), shortenUrl.isEnable(), thresholdContract);
    }
}
