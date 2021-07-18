package com.faasj.gateway.controller;

import com.faasj.gateway.dto.BuildDto;
import com.faasj.gateway.service.BuildAndDeployService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/build-and-deploy")
public class BuildAndDeployFunctionController {

    private final BuildAndDeployService buildAndDeployService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<BuildDto> buildAndDeployFunction(@RequestParam UUID functionId) {
        BuildDto buildDto = buildAndDeployService.buildAndDeployFunction(functionId);

        return Objects.nonNull(buildDto.getBuildId()) ?
                new ResponseEntity<>(buildDto, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}
