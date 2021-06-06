package com.faasj.gateway.dto;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class ProjectDto {

    UUID ownerId;
    String name;
    Map<String, String> tags;
}