package com.faasj.gateway.controller;

import com.faasj.gateway.service.TriggerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FunctionTriggerController {

    private final TriggerService service;

    @GetMapping(value = "/{functionName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> callFunction(@PathVariable String functionName) {
        String response = service.callFunction(functionName);

        return !response.isEmpty() ?
        new ResponseEntity<>(response, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
