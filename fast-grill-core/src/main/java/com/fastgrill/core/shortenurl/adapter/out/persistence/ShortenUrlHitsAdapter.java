package com.fastgrill.core.shortenurl.adapter.out.persistence;

import com.fastgrill.core.common.PersistenceAdapter;
import com.fastgrill.core.shortenurl.application.port.out.ShortenUrlHitsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

@PersistenceAdapter
@RequiredArgsConstructor
public class ShortenUrlHitsAdapter implements ShortenUrlHitsPort {
    private final RedisTemplate<String, Long> redisTemplate;

    @Override
    public long getHits(String shortenToken) {
        Long count = redisTemplate.opsForValue().get(getKey(shortenToken));
        return Objects.requireNonNullElse(count, 0L);
    }

    @Override
    public void increaseHits(String shortenToken) {
        redisTemplate.opsForValue().increment(getKey(shortenToken));
    }

    private String getKey(String shortenToken) {
        return "hits:" + shortenToken;
    }
}
