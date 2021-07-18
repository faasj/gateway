package com.faasj.gateway.dto;

import com.faasj.gateway.util.State;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
public class BuildDto {

    private UUID buildId;
    private UUID functionId;
    private State state;
    private Map<String, String> properties;
    private LocalDateTime created;
    private LocalDateTime updated;
}
