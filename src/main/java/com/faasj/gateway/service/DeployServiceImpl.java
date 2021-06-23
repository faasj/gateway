package com.faasj.gateway.service;

import com.faasj.gateway.dto.DeployDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeployServiceImpl implements DeployService {

    @Override
    public void deployFunction(UUID functionId) {

    }

    @Override
    public Optional<DeployDto> findInstance(String serviceName) {
        return Optional.empty();
    }
}
