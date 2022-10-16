package com.fastgrill.core.shortenurl.adapter.out.persistence;

import com.fastgrill.core.shortenurl.application.port.out.LoadClickUrlPort;
import com.fastgrill.core.shortenurl.domain.ClickUrl;
import com.fastgrill.core.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@PersistenceAdapter
public class LoadClickUrlPersistenceAdapter implements LoadClickUrlPort {
    private final ShortenUrlRepository shortenUrlRepository;
    private final ShortenUrlMapper shortenUrlMapper;

    @Override
    @Cacheable(value = "clickUrl", key = "#shortenToken")
    @Transactional(readOnly = true)
    public ClickUrl loadClickUrl(String shortenToken) {
        ShortenUrlJpaEntity shortenUrl = shortenUrlRepository.findByShortenToken(shortenToken)
                .orElseThrow(EntityNotFoundException::new);

        return shortenUrlMapper.mapToDomainEntity(shortenUrl);
    }
}
