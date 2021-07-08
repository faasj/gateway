package com.faasj.gateway.service;

import com.faasj.gateway.dto.DeployDto;
import com.faasj.gateway.dto.FunctionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeployServiceImpl implements DeployService {

    private final WebClient webClientForDeploy;
    private final FunctionService functionService;

    @Override
    public void deployFunction(UUID functionId) {
        FunctionDto functionDto = functionService.get(functionId).
                orElseThrow(() -> new NoSuchElementException("No such element " + functionId));

        ObjectMapper objectMapper = new ObjectMapper();

        webClientForDeploy.post()
                    .uri("/")
                    .body(BodyInserters.fromMultipartData(new LinkedMultiValueMap<>() {{
                        add("functionId", functionId.toString());
                        add("imageName", functionDto.getImage());
                        try {
                            add("environmentVariables", objectMapper
                                    .writeValueAsString(functionDto.getEnvironmentVariables()));
                            add("annotations", objectMapper
                                    .writeValueAsString(functionDto.getAnnotations()));
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    }}))
                    .retrieve()
                    .toBodilessEntity()
                    .subscribe();
    }

    @Override
    public Optional<DeployDto> findInstance(String serviceName) {
        return Optional.empty();
    }
}
