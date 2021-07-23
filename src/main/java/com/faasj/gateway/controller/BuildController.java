package com.faasj.gateway.controller;

import com.faasj.gateway.dto.BuildDto;
import com.faasj.gateway.service.BuildAndDeployService;
import com.faasj.gateway.service.BuildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/build")
public class BuildController {

    private final BuildService buildService;
    private final BuildAndDeployService buildAndDeployService;

    @GetMapping(value = "{buildId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BuildDto> getBuild(@PathVariable UUID buildId) {
        BuildDto buildDto = buildService.getBuild(buildId);

        return Objects.nonNull(buildDto.getBuildId()) ?
                new ResponseEntity<>(buildDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "{buildId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteBuild(@PathVariable UUID buildId) {
        buildService.deleteBuild(buildId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "logs/{buildId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLogs(@PathVariable UUID buildId) {
        String buildLogs = buildService.getBuildLogs(buildId);

        return Objects.nonNull(buildLogs) ?
                new ResponseEntity<>(buildLogs, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "logs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLogs() {
        String buildLogs = buildService.getBuildLogs();

        return Objects.nonNull(buildLogs) ?
                new ResponseEntity<>(buildLogs, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/status/{functionName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBuildStatus(@PathVariable String functionName) {
        String status = buildService.getBuildStatus(functionName);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
