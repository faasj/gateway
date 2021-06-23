package com.faasj.gateway.dto;

import lombok.Data;

import java.util.Map;

@Data
public class DeployDto {

    private String serviceName;
    private String version;
    private String image;
    private String envProcess;
    private Map<String, String> envVars;
    private Map<String, String> labels;
    private Map<String, String> annotations;
    private Map<String, String> limits;
    private Map<String, String> requests;
}
