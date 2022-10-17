package com.fastgrill.admin.shortenurl.adapter.in.web;

import com.fastgrill.admin.common.response.Response;
import com.fastgrill.admin.shortenurl.adapter.in.web.dto.*;
import com.fastgrill.admin.shortenurl.application.port.in.ShortenUrlAdminUseCase;
import com.fastgrill.core.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shorten-url")
public class ShortenUrlAdminController {
    private final ShortenUrlAdminUseCase shortenUrlAdminUseCase;

    @PostMapping
    public Response<CreateShortenUrlResponse> create(@Valid @RequestBody CreateShortenUrlRequest request) {
        var shortenUrl = shortenUrlAdminUseCase.create(request.toCommand());
        return Response.success(CreateShortenUrlResponse.fromShortenUrl(shortenUrl));
    }

    @GetMapping
    public Response<Page<ShortenUrlResponse>> list(Pageable pageable) {
        return Response.success(shortenUrlAdminUseCase.list(pageable).map(ShortenUrlResponse::fromShortenUrl));
    }

    @PatchMapping("/{shortenUrlId}")
    public Response<ModifyShortenUrlResponse> modify(@PathVariable Long shortenUrlId, @Valid @RequestBody ModifyShortenUrlRequest request) {
        var shortenUrl = shortenUrlAdminUseCase.modify(shortenUrlId, request.toCommand());
        return Response.success(ModifyShortenUrlResponse.fromShortenUrl(shortenUrl));
    }

    @PatchMapping("/{shortenUrlId}/enable")
    public Response<Void> enableUrl(@PathVariable Long shortenUrlId) {
        shortenUrlAdminUseCase.enableUrl(shortenUrlId);
        return Response.success();
    }

    @PatchMapping("/{shortenUrlId}/disable")
    public Response<Void> disableUrl(@PathVariable Long shortenUrlId) {
        shortenUrlAdminUseCase.disableUrl(shortenUrlId);
        return Response.success();
    }
}
