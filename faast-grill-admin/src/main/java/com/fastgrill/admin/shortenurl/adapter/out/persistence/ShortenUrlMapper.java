package com.fastgrill.admin.shortenurl.adapter.out.persistence;


import com.fastgrill.admin.shortenurl.application.port.in.ModifyShortenUrlCommand;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ShortenUrlMapper {
    ShortenUrl fromEntity(ShortenUrlJpaEntity shortenUrlJpaEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "originUrl", ignore = true)
    @Mapping(target = "shortenToken", ignore = true)
    @Mapping(target = "status", ignore = true)
    void updateEntity(ModifyShortenUrlCommand command, @MappingTarget ShortenUrlJpaEntity shortenUrlJpaEntity);
}
