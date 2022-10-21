package com.fastgrill.api.adapter.out.persistence;

import com.fastgrill.api.application.port.out.ShortenUrlPort;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.common.PersistenceAdapter;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@PersistenceAdapter
@RequiredArgsConstructor
public class ShortenUrlPersistenceAdapter implements ShortenUrlPort {
    private final ShortenUrlRepository shortenUrlRepository;
    private final ClickUrlMapper clickUrlMapper;

    @Override
    @Cacheable(value = "clickUrl", key = "#shortenToken")
    @Transactional(readOnly = true)
    public ClickUrl loadClickUrl(String shortenToken) {
        ShortenUrlJpaEntity shortenUrl = shortenUrlRepository.findByShortenToken(shortenToken)
                .orElseThrow(EntityNotFoundException::new);

        return clickUrlMapper.mapToDomainEntity(shortenUrl);
    }
}
