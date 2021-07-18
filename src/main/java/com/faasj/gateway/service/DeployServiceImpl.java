package com.faasj.gateway.service;

import com.faasj.gateway.dto.DeployDto;
import com.faasj.gateway.dto.DeployedFunctionsCountDto;
import com.faasj.gateway.dto.FunctionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeployServiceImpl implements DeployService {

    private final WebClient webClientForDeploy;
    private final FunctionService functionService;

    @Override
    public void deployFunction(UUID functionId) {
        FunctionDto functionDto = functionService.get(functionId).
                orElseThrow(() -> new NoSuchElementException("No such element " + functionId));

        webClientForDeploy.post()
                .uri("/")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(functionDto)
                .retrieve()
                .toBodilessEntity()
                .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(100)))
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .subscribe();
    }

    @Override
    public DeployDto findInstance(String serviceName) {

        return webClientForDeploy.get()
                .uri(String.join("", "/" + serviceName))
                .retrieve()
                .bodyToMono(DeployDto.class)
                .retryWhen(Retry.fixedDelay(1, Duration.ofMillis(1000)))
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(new DeployDto()))
                .block();
    }

    @Override
    public void deleteFunction(UUID functionId) {
        webClientForDeploy.delete()
                .uri(String.join("","/" + functionId))
                .retrieve()
                .toBodilessEntity()
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .subscribe();
    }

    @Override
    public String getLogs(String name, LocalDateTime since) {
        StringBuilder sb = new StringBuilder("/logs");
        if (Objects.nonNull(name) && Objects.nonNull(since)) {
            sb.append("?name=").append(name).append("&since=").append(since);
        } else if (Objects.nonNull(name)) {
            sb.append("?name=").append(name);
        } else if (Objects.nonNull(since)) {
            sb.append("?since=").append(since);
        }

        return webClientForDeploy.get()
                .uri(sb.toString())
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(error.getMessage()))
                .block();
    }

    @Override
    public DeployedFunctionsCountDto getDeployedFunctions() {
        return webClientForDeploy.get()
                .uri("/functions")
                .retrieve()
                .bodyToMono(DeployedFunctionsCountDto.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(new DeployedFunctionsCountDto(-1)))
                .block();
    }

    @Override
    public String getStatus(String functionName) {
        return webClientForDeploy.get()
                .uri(String.format("/status/%s", functionName))
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(error.getMessage()))
                .block();
    }
}
