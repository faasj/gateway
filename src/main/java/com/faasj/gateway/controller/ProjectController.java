package com.faasj.gateway.controller;

import com.faasj.gateway.dto.ProjectDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {

    @PostMapping("/create")
    public void createProject(@RequestBody ProjectDto dto) {
        log.info(dto.toString());
    }
}
