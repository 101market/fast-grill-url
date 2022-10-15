package com.fast.grill.click.domain

import spock.lang.Specification

import java.time.Instant

class ClickUrlTest extends Specification {
    def "click url 만료 시각이 과거인 경우, true를 반환한다"() {
        def pastDays = Instant.now().minusSeconds(60)
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

    def "click url 만료 시각이 미만인 경우, false 반환한다"() {
        def pastDays = Instant.now().plusSeconds(60)
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
