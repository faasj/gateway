package com.faasj.gateway.controller;

import com.faasj.gateway.dto.ProjectDto;
import com.faasj.gateway.service.FunctionService;
import com.faasj.gateway.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public void createProject(@RequestBody ProjectDto dto) {
        log.info(dto.toString());
    }
}
