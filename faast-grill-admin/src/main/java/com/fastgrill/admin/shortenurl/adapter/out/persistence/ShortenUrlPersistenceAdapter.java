package com.fastgrill.admin.shortenurl.adapter.out.persistence;

import com.fastgrill.admin.shortenurl.adapter.in.web.CreateShortenUrlCommand;
import com.fastgrill.admin.shortenurl.application.port.out.ShortenUrlPort;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import com.fastgrill.core.common.PersistenceAdapter;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlRepository;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@PersistenceAdapter
public class ShortenUrlPersistenceAdapter implements ShortenUrlPort {
    private final ShortenUrlRepository shortenUrlRepository;
    private final ShortenUrlMapper shortenUrlMapper;

    @Override
    public ShortenUrl create(CreateShortenUrlCommand command) {
        var shortenUrlJpaEntity = shortenUrlRepository.save(command.toEntity());
        return shortenUrlMapper.fromEntity(shortenUrlJpaEntity);
    }
}
