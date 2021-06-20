package com.faasj.gateway.service;

import com.faasj.gateway.dto.ProjectDto;
import com.faasj.gateway.entity.ProjectEntity;
import com.faasj.gateway.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectDto> getAll() {
        List<ProjectDto> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projectEntity -> projects.add(new ProjectDto(projectEntity)));
        return projects;
    }

    @Override
    public ProjectDto get(UUID projectId) {
        return new ProjectDto(projectRepository.findById(projectId).get());
    }

    @Override
    public void delete(UUID projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public void update(ProjectDto projectDto) {
        ProjectEntity projectEntity = ProjectEntity.builder()
                .projectId(projectDto.getProjectId())
                .projectName(projectDto.getName())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .ownerId(projectDto.getOwnerId())
                .tags(projectDto.getTags())
                .build();
        projectRepository.save(projectEntity);
    }

    @Override
    public void save(ProjectDto projectDto) {
        ProjectEntity projectEntity = ProjectEntity.builder()
                .projectId(UUID.randomUUID())
                .projectName(projectDto.getName())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .ownerId(projectDto.getOwnerId())
                .tags(projectDto.getTags())
                .build();
        log.info(projectEntity.toString());
        projectRepository.save(projectEntity);

    }

}
