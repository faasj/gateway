package com.faasj.gateway.controller;

import com.faasj.gateway.dto.FunctionDto;
import com.faasj.gateway.entity.FunctionEntity;
import com.faasj.gateway.service.FunctionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/functions")
public class FunctionController {

    private final FunctionService functionService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FunctionEntity> createFunction(@RequestBody FunctionDto dto) {
        log.info(dto.toString());

        functionService.save(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FunctionDto>> getFunctions() {
        List<FunctionDto> functions = functionService.getAll();

        if (functions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(functions, HttpStatus.OK);
    }

    @GetMapping(value = "/{functionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FunctionDto> getFunction(@PathVariable UUID functionId) {
        Optional<FunctionDto> function = functionService.get(functionId);

        if (function.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(function.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{functionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FunctionDto> deleteFunction(@PathVariable UUID functionId) {
        Optional<FunctionDto> function = functionService.get(functionId);

        if (function.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        functionService.delete(functionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FunctionDto> updateFunction(@RequestBody FunctionDto function) {
        functionService.update(function);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}