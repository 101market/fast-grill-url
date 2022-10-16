package com.fastgrill.core.shortenurl.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ShortenUrlRepository extends JpaRepository<ShortenUrlJpaEntity, Long> {
    Optional<ShortenUrlJpaEntity> findByShortenToken(String shortenToken);
}