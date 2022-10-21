package com.fastgrill.admin.shortenurl.adapter.in.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.fastgrill.admin.common.response.GlobalControllerAdvice
import com.fastgrill.admin.shortenurl.adapter.in.web.dto.CreateShortenUrlRequest
import com.fastgrill.admin.shortenurl.application.port.in.ShortenUrlAdminUseCase
import com.fastgrill.admin.shortenurl.domain.ShortenUrl
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class ShortenUrlAdminControllerSpec extends Specification {
    @Autowired
    MockMvc mockMvc

    @SpringBean
    ShortenUrlAdminUseCase shortenUrlAdminUseCase = Stub(ShortenUrlAdminUseCase)

    @Autowired
    ObjectMapper objectMapper

    def "shorten url을 생성한다"() {
        given:
        def request = CreateShortenUrlRequest.builder()
                .originUrl("https://github.com")
                .build()

        shortenUrlAdminUseCase.create(_) >> ShortenUrl.builder().build()

        expect:
        mockMvc.perform(post("/api/v1/shorten-url")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
