package com.faasj.gateway.service;

import com.faasj.gateway.dto.BuildDto;

import java.util.UUID;

public interface BuildService {

    BuildDto buildFunction(UUID functionId);

    void deleteBuild(UUID buildId);

    BuildDto getBuild(UUID buildId);

    String getBuildLogs(UUID buildId);

    String getBuildLogs();

    String getBuildStatus(String functionName);
}
