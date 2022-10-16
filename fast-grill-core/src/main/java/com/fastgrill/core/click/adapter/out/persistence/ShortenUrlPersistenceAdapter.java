package com.fastgrill.core.click.adapter.out.persistence;

import com.fastgrill.core.click.application.port.out.LoadShortenUrlPort;
import com.fastgrill.core.click.domain.ClickUrl;
import com.fastgrill.core.common.PersistenceAdapter;
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
