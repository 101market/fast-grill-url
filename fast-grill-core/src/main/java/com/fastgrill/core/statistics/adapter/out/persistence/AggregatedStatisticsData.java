package com.fastgrill.core.statistics.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AggregatedStatisticsData {
    private LocalDateTime statisticsAt; // 일 단위
    private long hits;

    public void merge(final AggregatedStatisticsData statistics) {
        this.hits += statistics.getHits();
    }
}
