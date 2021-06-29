package com.faasj.gateway.service;

import com.faasj.gateway.dto.BuildDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuildServiceImpl implements BuildService {

    @Override
    public BuildDto buildFunction(UUID function) {
        return null;
    }

    @Override
    public void deleteBuild(UUID build) {

    }

    @Override
    public BuildDto getBuild(UUID build) {
        return null;
    }

    @Override
    public String getBuildLogs(UUID build) {
        return null;
    }
}
