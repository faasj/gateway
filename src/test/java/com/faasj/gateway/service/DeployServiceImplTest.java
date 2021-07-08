package com.faasj.gateway.service;

import com.faasj.gateway.GatewayApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

class DeployServiceImplTest extends GatewayApplicationTests {

    @Autowired
    private DeployServiceImpl deployService;

    @Test
    void deployFunction() {
        deployService.deployFunction(UUID.fromString("f28f60d9-60f7-4e13-9602-1a3fc4298d0c"));
    }

    @Test
    void findInstance() {
    }
}
