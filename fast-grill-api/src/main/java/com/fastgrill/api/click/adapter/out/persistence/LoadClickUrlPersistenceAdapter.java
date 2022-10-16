package com.fastgrill.api.click.adapter.out.persistence;

import com.fastgrill.api.application.port.out.LoadClickUrlPort;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.common.PersistenceAdapter;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@PersistenceAdapter
public class LoadClickUrlPersistenceAdapter implements LoadClickUrlPort {
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
