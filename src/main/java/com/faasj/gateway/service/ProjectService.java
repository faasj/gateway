package com.faasj.gateway.service;

import com.faasj.gateway.entity.ProjectEntity;
import com.faasj.gateway.repository.ProjectRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepositoryInterface projectRepository;

    public void save(ProjectEntity projectEntity) {
        projectRepository.save(projectEntity);
    }

    public void delete(UUID projectId) {
        projectRepository.deleteById(projectId);
    }
}
