package com.fastgrill.core.statistics.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticsRepository extends JpaRepository<StatisticsJpaEntity, Integer> {

    @Query(value = "SELECT new com.fastgrill.core.statistics.adapter.out.persistence.AggregatedStatisticsData(s.statisticsAt, SUM(s.hits)) " +
            "         FROM StatisticsJpaEntity s " +
            "        WHERE s.statisticsAt BETWEEN :from AND :to " +
            "     GROUP BY s.statisticsAt")
    List<AggregatedStatisticsData> findByStatisticsAtBetweenAndGroupBy(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

}
