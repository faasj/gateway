package com.faasj.gateway.service;

import com.faasj.gateway.GatewayApplicationTests;
import com.faasj.gateway.dto.FunctionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FunctionServiceImplTest extends GatewayApplicationTests {

    private static final UUID ID = UUID.fromString("f28f60d9-60f7-4e13-9602-1a3fc4298d0c");

    @Autowired
    FunctionService service;

    @Test
    void testGetAll() {
        var functions = service.getAll();
        assertFalse(functions.isEmpty());

        assertEquals(ID, functions.get(0).getFunctionId());
    }

    @Test
    void testGetById() {
        var function = service.get(ID);
        assertTrue(function.isPresent());
        function.ifPresent(functionDto -> assertEquals(ID, functionDto.getFunctionId()));
    }

    @Test
    void testDelete() {
        var functionDtoBefore = service.get(ID);
        assertTrue(functionDtoBefore.isPresent());

        service.delete(ID);

        var functionDtoAfter = service.get(ID);
        assertFalse(functionDtoAfter.isPresent());
    }

    @Test
    void testSave() {
        assertEquals(1, service.getAll().size());

        FunctionDto dto = new FunctionDto();

        dto.setProjectId(UUID.fromString("f28f60d9-60f7-4e13-9602-1a3fc4298d02"));
        dto.setCode("some code");
        dto.setImage("image");
        dto.setName("test function");
        dto.setDescription("test");
        dto.setTags(Map.of("test", "test"));
        dto.setEnvironmentVariables(Map.of("test", "test"));
        dto.setLimits(Map.of("test", "test"));
        dto.setRequests(Map.of("test", "test"));

        service.save(dto);

        assertEquals(2, service.getAll().size());
    }

    @Test
    void testUpdate() {
        final String UPDATED = "updated filed";

        var function = service.get(ID).orElseThrow();
        assertNotEquals(UPDATED, function.getCode());

        function.setCode(UPDATED);
        service.update(function);

        assertEquals(UPDATED, service.get(ID).orElseThrow().getCode());
    }
}
