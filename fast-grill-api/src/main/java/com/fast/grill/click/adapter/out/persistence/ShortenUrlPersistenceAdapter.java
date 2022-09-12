package com.fast.grill.click.adapter.out.persistence;

import com.fast.grill.click.application.port.out.LoadShortenUrlPort;
import com.fast.grill.click.domain.ClickUrl;
import com.fast.grill.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@PersistenceAdapter
public class ShortenUrlPersistenceAdapter implements LoadShortenUrlPort {
    private final ShortenUrlRepository shortenUrlRepository;
    private final ShortenUrlMapper shortenUrlMapper;

    @Override
    public ClickUrl loadClickUrl(String shortenToken) {
       // TEST 용
       //  shortenUrlRepository.save(new ShortenUrlJpaEntity(null, shortenToken, "https://github.com/101market/fast-grill-url/", ShortenUrlJpaEntity.Status.ENABLE, ZonedDateTime.now().plusDays(3), 1L));

//        TODO: cache 조회 적용하기
        ShortenUrlJpaEntity shortenUrl = shortenUrlRepository.findByShortenToken(shortenToken)
                .orElseThrow(EntityNotFoundException::new);

        return shortenUrlMapper.mapToDomainEntity(shortenUrl);
    }
}
