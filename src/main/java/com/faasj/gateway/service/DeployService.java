package com.faasj.gateway.service;

import com.faasj.gateway.dto.DeployDto;

import java.util.Optional;
import java.util.UUID;

public interface DeployService {

    void deployFunction(UUID functionId);

    Optional<DeployDto> findInstance(String serviceName);
}
