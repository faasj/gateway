package com.faasj.gateway.controller;

import com.faasj.gateway.dto.FunctionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/function")
public class FunctionController {

    @PostMapping("/create")
    public void createFunction(@RequestBody FunctionDto dto) {
        log.info(dto.toString());
    }
}