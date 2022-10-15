package com.fast.grill.click.adapter.out.persistence;

import com.fast.grill.click.application.port.out.LoadShortenUrlPort;
import com.fast.grill.click.domain.ClickUrl;
import com.fast.grill.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@PersistenceAdapter
public class ShortenUrlPersistenceAdapter implements LoadShortenUrlPort {
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
