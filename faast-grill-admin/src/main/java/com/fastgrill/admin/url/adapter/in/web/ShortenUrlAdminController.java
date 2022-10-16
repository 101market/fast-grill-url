package com.fastgrill.admin.url.adapter.in.web;

import com.fastgrill.admin.common.response.Response;
import com.fastgrill.core.common.WebAdapter;
import com.fastgrill.core.shortenurl.application.port.in.ShortenUrlAdminUseCase;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shorten-url")
public class ShortenUrlAdminController {
    private final ShortenUrlAdminUseCase shortenUrlAdminUseCase;

    @PostMapping
    public Response<ShortenUrlCreateResponse> create(@Valid @RequestBody ShortenUrlCreateRequest request) {
        var shortenToken = shortenUrlAdminUseCase.create(request.toCommand());
        return Response.success(ShortenUrlCreateResponse.of(shortenToken));
    }
}
