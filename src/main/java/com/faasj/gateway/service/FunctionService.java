package com.faasj.gateway.service;

import com.faasj.gateway.dto.FunctionDto;
import com.faasj.gateway.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionService {

    @Autowired
    private FunctionRepository functionRepository;

    public List<FunctionDto> getAllFunctions() {
        return functionRepository.getAll();
    }

    public FunctionDto getFunctionById() {
        return functionRepository.getById();
    }

    public FunctionDto create() {
        return functionRepository.create();
    }

    public FunctionDto delete() {
        return functionRepository.delete();
    }
}
