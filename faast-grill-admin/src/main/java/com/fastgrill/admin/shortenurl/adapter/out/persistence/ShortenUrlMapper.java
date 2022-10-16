package com.fastgrill.admin.shortenurl.adapter.out.persistence;


import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface ShortenUrlMapper {
    ShortenUrl fromEntity(ShortenUrlJpaEntity shortenUrlJpaEntity);
}
