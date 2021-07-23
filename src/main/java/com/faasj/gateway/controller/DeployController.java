package com.faasj.gateway.controller;

import com.faasj.gateway.dto.DeployDto;
import com.faasj.gateway.dto.DeployedFunctionsCountDto;
import com.faasj.gateway.service.DeployService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deploy")
public class DeployController {

    private final DeployService service;

    @DeleteMapping("{functionId}")
    public ResponseEntity<HttpStatus> uninstallFunction(@PathVariable UUID functionId) {
        service.deleteFunction(functionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{serviceName}")
    public ResponseEntity<DeployDto> getDeploy(@PathVariable String serviceName) {
        DeployDto deployDto = service.findInstance(serviceName);

        return Objects.isNull(deployDto) || Objects.isNull(deployDto.getServiceName()) ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(deployDto, HttpStatus.OK);
    }

    @GetMapping(value = ("logs"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLogs(@RequestParam(required = false) String name,
                                          @RequestParam(required = false)
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime since) {
        String logs = service.getLogs(name, since);

        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    @GetMapping(value = ("functions"), produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeployedFunctionsCountDto> getDeployedFunctions() {
        DeployedFunctionsCountDto deployedFunctions = service.getDeployedFunctions();

        return deployedFunctions.count() >= 0 ?
                new ResponseEntity<>(deployedFunctions, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "status/{functionName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDeployStatus(@PathVariable String functionName) {
        String status = service.getStatus(functionName);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
