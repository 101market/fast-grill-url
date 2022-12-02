package com.fastgrill.api.config;

import com.fastgrill.api.common.interceptor.CommonHttpRequestInterceptor;
import com.fastgrill.api.common.resolver.RefererHandlerMethodArgumentResolver;
import com.fastgrill.api.common.resolver.RequestEventIdHandlerMethodArgumentResolver;
import com.fastgrill.api.common.resolver.UserAgentMethodArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class AppConfig implements WebMvcConfigurer {
    private final CommonHttpRequestInterceptor commonHttpRequestInterceptor;
    private final RequestEventIdHandlerMethodArgumentResolver requestEventIdHandlerMethodArgumentResolver;
    private final UserAgentMethodArgumentResolver userAgentMethodArgumentResolver;
    private final RefererHandlerMethodArgumentResolver refererHandlerMethodArgumentResolver;

    @Bean
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor();
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver() {
        return new DeviceHandlerMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceResolverHandlerInterceptor());
        registry.addInterceptor(commonHttpRequestInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
        argumentResolvers.add(requestEventIdHandlerMethodArgumentResolver);
        argumentResolvers.add(userAgentMethodArgumentResolver);
        argumentResolvers.add(refererHandlerMethodArgumentResolver);
    }
}
