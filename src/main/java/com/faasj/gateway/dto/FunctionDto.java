package com.faasj.gateway.dto;

import com.faasj.gateway.entity.FunctionEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
public class FunctionDto {

    private UUID functionId;
    private UUID projectId;
    private String name;
    private String code;
    private String description;
    private String image;
    private Map<String, String> tags;
    private Map<String, String> environmentVariables;
    private Map<String, String> limits;
    private Map<String, String> requests;

    public FunctionDto(FunctionEntity functionEntity) {
        this.functionId = functionEntity.getFunctionId();
        this.projectId = functionEntity.getProjectId();
        this.name = functionEntity.getFunctionName();
        this.code = functionEntity.getCode();
        this.description = functionEntity.getDescription();
        this.image = functionEntity.getImage();
        this.tags = functionEntity.getTags();
        this.environmentVariables = functionEntity.getEnvironmentVariables();
        this.limits = functionEntity.getLimits();
        this.requests = functionEntity.getRequests();
    }
}
