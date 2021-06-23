package com.faasj.gateway.controller;

import com.faasj.gateway.dto.ProjectDto;
import com.faasj.gateway.service.ProjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectDto>> getAllProjects() {

        return new ResponseEntity<>(projectService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto dto) {

        projectService.save(dto);
        log.info(dto.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDto> getProject(@PathVariable UUID projectId) {

        return new ResponseEntity<>(projectService.get(projectId), HttpStatus.OK);
    }

    @PutMapping(value = "/{projectId}")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto) {

        projectService.update(projectDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{projectId}")
    public ResponseEntity<ProjectDto> deleteProject(@PathVariable UUID projectId) {

        projectService.delete(projectId);
        // удалить все функции в проекте
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
