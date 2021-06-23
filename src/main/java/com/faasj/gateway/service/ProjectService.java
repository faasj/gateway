package com.faasj.gateway.service;

import com.faasj.gateway.dto.ProjectDto;

import java.util.List;
import java.util.UUID;

public interface ProjectService {

    List<ProjectDto> getAll();

    ProjectDto get(UUID projectId);

    void delete(UUID projectId);

    void update(ProjectDto projectDto);

    void save(ProjectDto projectDto);

}
