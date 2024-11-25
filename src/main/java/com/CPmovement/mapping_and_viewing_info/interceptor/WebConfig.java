package com.CPmovement.mapping_and_viewing_info.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ApiStatisticsInterceptor apiStatisticsInterceptor;

    public WebConfig(ApiStatisticsInterceptor apiStatisticsInterceptor) {
        this.apiStatisticsInterceptor = apiStatisticsInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiStatisticsInterceptor);
    }
}