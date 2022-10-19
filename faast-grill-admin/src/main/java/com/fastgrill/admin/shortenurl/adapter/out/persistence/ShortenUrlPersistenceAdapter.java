package com.fastgrill.admin.shortenurl.adapter.out.persistence;

import com.fastgrill.admin.shortenurl.application.port.in.CreateShortenUrlCommand;
import com.fastgrill.admin.shortenurl.application.port.in.ModifyShortenUrlCommand;
import com.fastgrill.admin.shortenurl.application.port.out.ShortenUrlPort;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import com.fastgrill.core.common.PersistenceAdapter;
import com.fastgrill.core.common.exception.BaseException;
import com.fastgrill.core.common.exception.ErrorCode;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@PersistenceAdapter
public class ShortenUrlPersistenceAdapter implements ShortenUrlPort {
    private final ShortenUrlRepository shortenUrlRepository;
    private final ShortenUrlMapper shortenUrlMapper;

    @Override
    @Transactional
    public ShortenUrl create(CreateShortenUrlCommand command) {
        var shortenUrlJpaEntity = shortenUrlRepository.save(command.toEntity());
        shortenUrlRepository.saveAndFlush(shortenUrlJpaEntity);
        return shortenUrlMapper.fromEntity(shortenUrlJpaEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ShortenUrl> list(Pageable pageable) {
        return shortenUrlRepository.findAll(pageable).map(shortenUrlMapper::fromEntity);
    }

    @Override
    @Transactional
    public ShortenUrl modify(Long shortenUrlId, ModifyShortenUrlCommand command) {
        ShortenUrlJpaEntity shortenUrlJpaEntity = getShortenUrlJpaEntity(shortenUrlId);
        shortenUrlMapper.updateEntity(command, shortenUrlJpaEntity);
        shortenUrlRepository.save(shortenUrlJpaEntity);
        return shortenUrlMapper.fromEntity(shortenUrlJpaEntity);
    }

    @Override
    @Transactional
    public void enableUrl(Long shortenUrlId) {
        ShortenUrlJpaEntity shortenUrlJpaEntity = getShortenUrlJpaEntity(shortenUrlId);
        shortenUrlJpaEntity.enable();
    }

    @Override
    @Transactional
    public void disableUrl(Long shortenUrlId) {
        ShortenUrlJpaEntity shortenUrlJpaEntity = getShortenUrlJpaEntity(shortenUrlId);
        shortenUrlJpaEntity.disable();
    }

    private ShortenUrlJpaEntity getShortenUrlJpaEntity(Long shortenUrlId) {
        return shortenUrlRepository.findById(shortenUrlId)
                .orElseThrow(() ->
                        new BaseException(ErrorCode.SHORTEN_URL_NOT_FOUND, String.format("shortenId 번호는 %d입니다.", shortenUrlId))
                );
    }
}
