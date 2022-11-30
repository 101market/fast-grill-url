package com.fastgrill.api.adapter.in.rest;

import com.fastgrill.api.application.port.in.ClickCommand;
import com.fastgrill.api.application.port.in.ClickUseCase;
import com.fastgrill.core.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ShortenUrlClickController {
    private final ClickUseCase clickUseCase;

    @GetMapping(path = "/{shortenToken}")
    ResponseEntity click(@PathVariable("shortenToken") String shortenToken,
                         @RequestHeader(value = "Referer", required = false) String referer,
                         @RequestHeader(value = "user-agent", required = false) String userAgent
    ) {
        ClickCommand command = new ClickCommand(shortenToken, referer, userAgent);
        String redirectUrl = clickUseCase.clickShortenUrl(command);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(redirectUrl))
                .build();
    }
}
