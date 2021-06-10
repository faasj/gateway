package com.faasj.gateway.service;

import com.faasj.gateway.dto.ProjectDto;
import com.faasj.gateway.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectDto> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    public ProjectDto getProjectById() {
        return projectRepository.getProjectById();
    }

    public ProjectDto create() {
        return projectRepository.create();
    }

    public ProjectDto delete() {
        return projectRepository.delete();
    }

}
