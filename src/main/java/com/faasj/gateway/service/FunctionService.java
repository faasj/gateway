package com.faasj.gateway.service;

import com.faasj.gateway.dto.FunctionDto;
import com.faasj.gateway.entity.FunctionEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FunctionService {

    void delete(UUID functionId);

    void save(FunctionDto functionDto);

    void update(FunctionDto functionDto);

    List<FunctionDto> getAll();

    Optional<FunctionDto> get(UUID functionId);
}
