package com.faasj.gateway.service;

import com.faasj.gateway.dto.BuildDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuildAndDeployServiceImpl implements BuildAndDeployService {

    private final BuildService buildService;
    private final DeployService deployService;

    @Override
    public BuildDto buildAndDeployFunction(UUID functionId) {

        BuildDto buildDto = buildService.buildFunction(functionId);
        deployService.deployFunction(functionId);

        return buildDto;
    }
}
