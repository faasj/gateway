package com.faasj.gateway.service;

import com.faasj.gateway.dto.ProjectDto;
import com.faasj.gateway.entity.ProjectEntity;
import com.faasj.gateway.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void delete(UUID projectId) {
        projectRepository.deleteById(projectId);
    }

    public void save(ProjectDto projectDto) {
        ProjectEntity projectEntity = ProjectEntity.builder()
                .projectId(UUID.randomUUID())
                .projectName(projectDto.getName())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .ownerId(projectDto.getOwnerId())
                .tags(projectDto.getTags())
                .build();
        projectRepository.save(projectEntity);
    }

}
