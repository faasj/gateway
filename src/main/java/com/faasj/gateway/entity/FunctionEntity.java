package com.faasj.gateway.entity;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class FunctionEntity {

    private UUID functionId;
    private String functionName;
    private String code;
    private String description;
    private String image;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private UUID projectId;
    private Map<String, String> tags;
    private Map<String, String> environmentVariables;
    private Map<String, String> limits;
    private Map<String, String> requests;
}
