package com.faasj.gateway.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class ProjectEntity {

    private UUID projectId;
    private String projectName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private UUID ownerId;
    private Map<String, String> tags;
}
