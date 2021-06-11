package com.faasj.gateway.service;

import com.faasj.gateway.entity.ProjectEntity;
import com.faasj.gateway.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    public ProjectEntity getProjectById() {
        return projectRepository.getProjectById();
    }

    public ProjectEntity create() {
        return projectRepository.create();
    }

    public ProjectEntity delete() {
        return projectRepository.delete();
    }

}
