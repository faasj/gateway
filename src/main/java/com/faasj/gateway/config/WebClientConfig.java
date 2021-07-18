package com.faasj.gateway.config;

import io.netty.channel.ChannelOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {

    @Value("${baseurl.deploy}")
    private String deployBaseUrl;

    @Value("${baseurl.build}")
    private String buildBaseUrl;

    private static final HttpClient HTTP_CLIENT = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);

    @Bean
    public WebClient webClientForDeploy() {

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HTTP_CLIENT))
                .baseUrl(deployBaseUrl)
                .build();
    }

    @Bean
    public WebClient webClientForBuild() {

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HTTP_CLIENT))
                .baseUrl(buildBaseUrl)
                .build();
    }
}
