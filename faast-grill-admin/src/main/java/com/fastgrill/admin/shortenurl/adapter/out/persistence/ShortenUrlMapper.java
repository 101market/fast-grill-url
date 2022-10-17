package com.fastgrill.admin.shortenurl.adapter.out.persistence;


import com.fastgrill.admin.shortenurl.application.port.in.ModifyShortenUrlCommand;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring"
)
public interface ShortenUrlMapper {
    ShortenUrl toShortenUrl(ShortenUrlJpaEntity shortenUrlJpaEntity);

    void updateEntity(@MappingTarget ShortenUrlJpaEntity shortenUrlJpaEntity, ModifyShortenUrlCommand command);
}
