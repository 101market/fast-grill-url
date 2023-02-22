package com.fastgrill.core.statistics.adapter.out.persistence;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "statistics")
public class StatisticsJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long shortenUrlId;

    private LocalDateTime statisticsAt; // 일 단위
    private Long hits;

    public static StatisticsJpaEntity create(final Long shortenUrlId) {
        StatisticsJpaEntity statisticsJpaEntity = new StatisticsJpaEntity();
        statisticsJpaEntity.setShortenUrlId(shortenUrlId);
        statisticsJpaEntity.setStatisticsAt(convertToStatisticsAt(LocalDateTime.now()));
        statisticsJpaEntity.setHits(1L);
        return statisticsJpaEntity;
    }

    public void add(final Long shortenUrlId) {
        this.hits++;
    }

    private static LocalDateTime convertToStatisticsAt(LocalDateTime dateTime) {
        return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }
}
