package com.faasj.gateway.dto;

import com.faasj.gateway.entity.ProjectEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor

public class ProjectDto {

    UUID projectId;
    String name;
    UUID ownerId;
    Map<String, String> tags;

    public ProjectDto(ProjectEntity projectEntity) {
        this.projectId = projectEntity.getProjectId();
        this.name = projectEntity.getProjectName();
        this.ownerId = projectEntity.getOwnerId();
        this.tags = projectEntity.getTags();
    }
}