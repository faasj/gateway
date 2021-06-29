package com.faasj.gateway.service;

import com.faasj.gateway.dto.BuildDto;

import java.util.UUID;

public interface BuildService {

    BuildDto buildFunction(UUID function);

    void deleteBuild(UUID build);

    BuildDto getBuild(UUID build);

    String getBuildLogs(UUID build);
}
