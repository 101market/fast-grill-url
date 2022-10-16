package com.fastgrill.api.click.adapter.in.web;

import com.fastgrill.core.shortenurl.application.port.in.ClickCommand;
import com.fastgrill.core.shortenurl.application.port.in.ClickUseCase;
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
@RequestMapping("api/v1")
public class ShortenUrlClickController {
    private final ClickUseCase clickUseCase;

    @GetMapping(path = "/{shortenToken}")
    ResponseEntity click(
            @PathVariable("shortenToken") String shortenToken) {
        ClickCommand command = new ClickCommand(shortenToken);
        String redirectUrl = clickUseCase.clickShortenUrl(command);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(redirectUrl))
                .build();
    }
}
