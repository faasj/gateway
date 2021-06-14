package com.faasj.gateway.service;

import com.faasj.gateway.dto.FunctionDto;
import com.faasj.gateway.entity.FunctionEntity;
import com.faasj.gateway.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FunctionService {

    @Autowired
    private FunctionRepository functionRepository;

    public void delete(UUID functionId) {
        functionRepository.deleteById(functionId);
    }

    public void save(FunctionDto functionDto) {
        FunctionEntity entity = FunctionEntity.builder()
                .functionId(UUID.randomUUID())
                .functionName(functionDto.getName())
                .code(functionDto.getCode())
                .description(functionDto.getDescription())
                .image(functionDto.getImage())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .projectId(functionDto.getProjectId())
                .tags(functionDto.getTags())
                .environmentVariables(functionDto.getEnvironmentVariables())
                .limits(functionDto.getLimits())
                .requests(functionDto.getRequests())
                .build();
        functionRepository.save(entity);
    }

}
