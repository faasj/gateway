package com.faasj.gateway.controller;

import com.faasj.gateway.service.DeployService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deploy")
public class DeployController {

    private final DeployService service;

    @PostMapping
    public ResponseEntity<HttpStatus> deployFunction(@RequestParam UUID functionId) {
        service.deployFunction(functionId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
