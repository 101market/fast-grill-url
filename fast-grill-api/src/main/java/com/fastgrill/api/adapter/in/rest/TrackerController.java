package com.fastgrill.api.adapter.in.rest;

import com.fastgrill.api.application.port.in.ClickCommand;
import com.fastgrill.api.application.port.in.ImpressionCommand;
import com.fastgrill.api.application.port.in.TrackerUseCase;
import com.fastgrill.api.common.resolver.Referer;
import com.fastgrill.api.common.resolver.RequestEventId;
import com.fastgrill.api.common.resolver.UserAgent;
import com.fastgrill.core.common.WebAdapter;
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

    @GetMapping(path = "/imp/{shortenToken}")
    ResponseEntity<Void> impression(@PathVariable("shortenToken") String shortenToken,
                                    @Referer String referer,
                                    @UserAgent String userAgent,
                                    @RequestEventId String requestEventId
    ) {
        ImpressionCommand command = new ImpressionCommand(shortenToken, referer, userAgent, requestEventId);
        trackerUseCase.impression(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/click/{shortenToken}")
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
