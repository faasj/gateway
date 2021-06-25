package com.faasj.gateway.service;

import com.faasj.gateway.dto.FunctionDto;
import com.faasj.gateway.entity.FunctionEntity;
import com.faasj.gateway.repository.FunctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FunctionServiceImpl implements FunctionService {

    private final FunctionRepository functionRepository;

    @Override
    public void delete(UUID functionId) {
        functionRepository.deleteById(functionId);
    }

    @Override
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

    @Override
    public void update(FunctionDto functionDto) {
        FunctionEntity entity = FunctionEntity.builder()
                .functionId(functionDto.getFunctionId())
                .functionName(functionDto.getName())
                .code(functionDto.getCode())
                .description(functionDto.getDescription())
                .image(functionDto.getImage())
                .updateDate(LocalDateTime.now())
                .projectId(functionDto.getProjectId())
                .tags(functionDto.getTags())
                .environmentVariables(functionDto.getEnvironmentVariables())
                .limits(functionDto.getLimits())
                .requests(functionDto.getRequests())
                .build();
        functionRepository.save(entity);
    }


    @Override
    public List<FunctionDto> getAll() {
        List<FunctionDto> dtos = new ArrayList<>();
        functionRepository.findAll().forEach(entity -> dtos.add(new FunctionDto(entity)));
        return dtos;
    }

    @Override
    public Optional<FunctionDto> get(UUID functionId) {
        return functionRepository.findById(functionId).map(FunctionDto::new);
    }
}
