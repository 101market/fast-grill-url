package com.fast.grill.click.adapter.out.persistence;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
// TODO: 주석처리 한 것들 풀기
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
// TODO: core로 엔티티 옮기기
public class AbstractJpaEntity {
    // FIXME: 컬럼이 추가되지 않는 문제가 있음
    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
