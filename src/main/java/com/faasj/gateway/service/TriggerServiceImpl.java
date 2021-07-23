package com.faasj.gateway.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TriggerServiceImpl implements TriggerService {

    @Override
    public String callFunction(String functionName) {
        String baseUrl = String.join("", "http://", functionName);

        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();

        return webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(""))
                .block();
    }
}
