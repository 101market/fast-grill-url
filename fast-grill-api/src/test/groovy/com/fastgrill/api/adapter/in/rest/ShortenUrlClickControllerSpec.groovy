package com.fastgrill.api.adapter.in.rest

import com.fastgrill.api.application.port.in.ClickUseCase
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShortenUrlClickControllerSpec extends Specification {
    @Autowired
    private MockMvc mvc
    @SpringBean
    private ClickUseCase clickUseCase = Stub(ClickUseCase)

    def "원본 url으로 리다이렉트한다"() {
        given:
        def landingUrl = "www.fast-grill-url.com"
        clickUseCase.clickShortenUrl(_) >> landingUrl

        expect:
        mvc.perform(get("/api/v1/12k3ms#"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(landingUrl))
    }
}
