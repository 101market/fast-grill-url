package com.fastgrill.api.adapter.in.rest;

import com.fastgrill.api.application.port.in.ClickCommand;
import com.fastgrill.api.application.port.in.ImpressionCommand;
import com.fastgrill.api.application.port.in.TrackerUseCase;
import com.fastgrill.api.common.resolver.Referer;
import com.fastgrill.api.common.resolver.RequestEventId;
import com.fastgrill.api.common.resolver.UserAgent;
import com.fastgrill.core.common.WebAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/trackers")
public class TrackerController {
    private final TrackerUseCase trackerUseCase;

    @Operation(summary = "노출 트래킹", description = "시안이 노출될 때, 호출되는 노출 트래킹 API")
    @GetMapping(path = "/imp/{shortenToken}")
    @Parameters({
            @Parameter(name = "shortenToken", description = "단축 URL 토큰", example = "RXad41E"),
            @Parameter(name = "referer", description = "referer url", required = false),
            @Parameter(name = "userAgent", description = "userAgent", required = false),
            @Parameter(name = "requestEventId", description = "requestEventId", required = false)
    })
    ResponseEntity<Void> impression(@PathVariable("shortenToken") String shortenToken,
                                    @Referer String referer,
                                    @UserAgent String userAgent,
                                    @RequestEventId String requestEventId
    ) {
        ImpressionCommand command = new ImpressionCommand(shortenToken, referer, userAgent, requestEventId);
        trackerUseCase.impression(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "클릭 트래킹", description = "시안이 클릭될 때, 호출되는 클릭 트래킹 API")
    @GetMapping(path = "/clk/{shortenToken}")
    @Parameters({
            @Parameter(name = "shortenToken", description = "단축 URL 토큰", example = "RXad41E"),
            @Parameter(name = "referer", description = "referer url", required = false),
            @Parameter(name = "userAgent", description = "userAgent", required = false),
            @Parameter(name = "requestEventId", description = "requestEventId", required = false)
    })
    ResponseEntity click(@PathVariable("shortenToken") String shortenToken,
                         @Referer String referer,
                         @UserAgent String userAgent,
                         @RequestEventId String requestEventId
    ) {
        ClickCommand command = new ClickCommand(shortenToken, referer, userAgent, requestEventId);
        String landingUrl = trackerUseCase.click(command);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(landingUrl))
                .build();
    }
}
