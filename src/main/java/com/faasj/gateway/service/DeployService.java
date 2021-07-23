package com.faasj.gateway.service;

import com.faasj.gateway.dto.DeployDto;
import com.faasj.gateway.dto.DeployedFunctionsCountDto;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DeployService {

    void deployFunction(UUID functionId);

    DeployDto findInstance(String serviceName);

    void deleteFunction(UUID functionId);

    String getLogs(String name, LocalDateTime since);

    DeployedFunctionsCountDto getDeployedFunctions();

    String getStatus(String functionName);
}
