package com.faasj.gateway.service;

import com.faasj.gateway.dto.FunctionDto;
import com.faasj.gateway.entity.FunctionEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FunctionService {

    void delete(UUID functionId);

    void save(FunctionDto functionDto);

    void update(FunctionEntity functionEntity);

    List<FunctionEntity> getAll();

    Optional<FunctionEntity> getById(UUID functionId);
}
