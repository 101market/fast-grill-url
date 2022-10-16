package com.fastgrill.api.click.adapter.in.web;

import com.fastgrill.core.click.application.port.in.ClickShortenUrlCommand;
import com.fastgrill.core.click.application.port.in.ClickShortenUrlUseCase;
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
public class ClickShortenUrlController {
    private final ClickShortenUrlUseCase clickShortenUrlUseCase;

    @GetMapping(path = "/{shortenToken}")
    ResponseEntity click(
            @PathVariable("shortenToken") String shortenToken) {
        ClickShortenUrlCommand command = new ClickShortenUrlCommand(shortenToken);
        String redirectUrl = clickShortenUrlUseCase.clickShortenUrl(command);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(redirectUrl))
                .build();
    }
}
