package com.faasj.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${baseurl.deploy}")
    private String deployBaseUrl;

    @Bean
    public WebClient webClientForDeploy() {

        return WebClient.builder()
                .baseUrl(deployBaseUrl)
                .build();
    }
}
