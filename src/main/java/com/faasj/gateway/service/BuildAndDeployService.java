package com.faasj.gateway.service;

import com.faasj.gateway.dto.BuildDto;

import java.util.UUID;

public interface BuildAndDeployService {

    BuildDto buildAndDeployFunction(UUID functionId);
}
