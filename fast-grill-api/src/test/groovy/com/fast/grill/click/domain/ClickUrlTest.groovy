package com.fast.grill.click.domain

import spock.lang.Specification

import java.time.ZonedDateTime

class ClickUrlTest extends Specification {
    def "click url 만료 시각이 과거인 경우, true를 반환한다"() {
        def pastDays = ZonedDateTime.now().minusDays(1)
        given:
        def clickThresholdContract = ClickThresholdContract.builder()
                .expiredAt(pastDays)
                .build()
        def clickUrl = ClickUrl.builder()
                .thresholdContract(clickThresholdContract)
                .build()

        expect:
        clickUrl.isExpired()
    }

    def "click url 만료 시각이 미인 경우, false 반환한다"() {
        def pastDays = ZonedDateTime.now().plusDays(1)
        given:
        def clickThresholdContract = ClickThresholdContract.builder()
                .expiredAt(pastDays)
                .build()
        def clickUrl = ClickUrl.builder()
                .thresholdContract(clickThresholdContract)
                .build()

        expect:
        clickUrl.isExpired() == false
    }
}
