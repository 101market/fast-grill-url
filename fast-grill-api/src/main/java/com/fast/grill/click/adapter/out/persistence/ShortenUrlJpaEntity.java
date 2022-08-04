package com.fast.grill.click.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;


@Entity
@Table(name = "shorten_url")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortenUrlJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String shortenToken;

    private String originUrl;

    private ZonedDateTime expiredAt;
}
