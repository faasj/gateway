package com.faasj.gateway.service;

import com.faasj.gateway.dto.BuildDto;
import com.faasj.gateway.dto.FunctionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuildServiceImpl implements BuildService {

    private final FunctionService functionService;
    private final WebClient webClientForBuild;

    @Override
    public BuildDto buildFunction(UUID functionId) {
        FunctionDto functionDto = functionService.get(functionId)
                .orElseThrow(() -> new NoSuchElementException("No such element " + functionId));

        return webClientForBuild.post()
                .uri("/")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(functionDto)
                .retrieve()
                .bodyToMono(BuildDto.class)
                .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(1000)))
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .block();
    }

    @Override
    public void deleteBuild(UUID buildId) {
        webClientForBuild.delete()
                .uri(String.join("", "/", buildId.toString()))
                .retrieve()
                .toBodilessEntity()
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .subscribe();
    }

    @Override
    public BuildDto getBuild(UUID buildId) {

        return webClientForBuild.get()
                .uri(String.join("", "/", buildId.toString()))
                .retrieve()
                .bodyToMono(BuildDto.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(new BuildDto()))
                .block();
    }

    @Override
    public String getBuildLogs(UUID buildId) {

        return webClientForBuild.get()
                .uri(String.join("", "/logs/", buildId.toString()))
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(error.getMessage()))
                .block();
    }

    @Override
    public String getBuildLogs() {

        return webClientForBuild.get()
                .uri("/logs")
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(error.getMessage()))
                .block();
    }

    @Override
    public String getBuildStatus(String functionName) {

        return webClientForBuild.get()
                .uri(String.format("/status/%s", functionName))
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(error.getMessage()))
                .block();
    }
}
