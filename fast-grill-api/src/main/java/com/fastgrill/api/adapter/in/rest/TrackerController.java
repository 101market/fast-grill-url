package com.fastgrill.api.adapter.in.rest;

import com.fastgrill.api.application.port.in.ClickCommand;
import com.fastgrill.api.application.port.in.ConversionCommand;
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
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/trackers")
public class TrackerController {
    private final TrackerUseCase trackerUseCase;

    @Operation(summary = "노출 트래킹", description = "시안이 노출될 때, 호출되는 노출 트래킹 API")
    @GetMapping(path = "/impression/{shortenToken}")
    @Parameters({
            @Parameter(name = "shortenToken", description = "단축 URL 토큰", example = "RXad41E"),
            @Parameter(name = "trackId", description = "이벤트 트래킹 고유 식별자", example = "6c108a57-9801-40fd-90b7-dbcbfd49dd4b"),
            @Parameter(name = "referer", description = "referer url", required = false),
            @Parameter(name = "userAgent", description = "userAgent", required = false),
            @Parameter(name = "requestEventId", description = "requestEventId", required = false)
    })
    ResponseEntity<Void> impression(@PathVariable("shortenToken") String shortenToken,
                                    @RequestParam String trackId,
                                    @Referer String referer,
                                    @UserAgent String userAgent,
                                    @RequestEventId String requestEventId
    ) {
        ImpressionCommand command = new ImpressionCommand(shortenToken, trackId, referer, userAgent, requestEventId);
        trackerUseCase.impression(command);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @Operation(summary = "클릭 트래킹", description = "시안이 클릭될 때, 호출되는 클릭 트래킹 API")
    @GetMapping(path = "/click/{shortenToken}")
    @Parameters({
            @Parameter(name = "shortenToken", description = "단축 URL 토큰", example = "RXad41E"),
            @Parameter(name = "trackId", description = "이벤트 트래킹 고유 식별자", example = "6c108a57-9801-40fd-90b7-dbcbfd49dd4b"),
            @Parameter(name = "referer", description = "referer url"),
            @Parameter(name = "userAgent", description = "userAgent"),
            @Parameter(name = "requestEventId", description = "requestEventId")
    })
    ResponseEntity click(@PathVariable("shortenToken") String shortenToken,
                         @RequestParam String trackId,
                         @Referer String referer,
                         @UserAgent String userAgent,
                         @RequestEventId String requestEventId
    ) {
        ClickCommand command = new ClickCommand(shortenToken, trackId, referer, userAgent, requestEventId);
        String landingUrl = trackerUseCase.click(command);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(landingUrl))
                .build();
    }

    @Operation(summary = "전환 트래킹", description = "시안이 클릭 후, 원하는 이벤트로 전환되었을 때 호출되는 전환 트래킹 API")
    @GetMapping(path = "/conversion/{shortenToken}")
    @Parameters({
            @Parameter(name = "shortenToken", description = "단축 URL 토큰", example = "RXad41E"),
            @Parameter(name = "trackId", description = "이벤트 트래킹 고유 식별자", example = "6c108a57-9801-40fd-90b7-dbcbfd49dd4b"),
            @Parameter(name = "referer", description = "referer url", required = false),
            @Parameter(name = "userAgent", description = "userAgent", required = false),
            @Parameter(name = "requestEventId", description = "requestEventId", required = false)
    })
    ResponseEntity conversion(@PathVariable("shortenToken") String shortenToken,
                              @RequestParam String trackId,
                              @Referer String referer,
                              @UserAgent String userAgent,
                              @RequestEventId String requestEventId
    ) {
        ConversionCommand command = new ConversionCommand(shortenToken, trackId, referer, userAgent, requestEventId);
        trackerUseCase.convert(command);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
