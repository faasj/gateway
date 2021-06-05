package com.faasj.gateway.dto;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class FunctionDto {

    private UUID projectId;
    private String name;
    private String code;
    private String description;
    private String image;
    private Map<String, String> tags;
    private Map<String, String> environmentVariables;
    private Map<String, String> limits;
    private Map<String, String> requests;

    public FunctionDto() {
        this.projectId = UUID.randomUUID();
    }
}
