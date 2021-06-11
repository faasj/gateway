package com.faasj.gateway.service;

import com.faasj.gateway.entity.FunctionEntity;
import com.faasj.gateway.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionService {

    @Autowired
    private FunctionRepository functionRepository;

    public List<FunctionEntity> getAllFunctions() {
        return functionRepository.getAll();
    }

    public FunctionEntity getFunctionById() {
        return functionRepository.getById();
    }

    public FunctionEntity create() {
        return functionRepository.create();
    }

    public FunctionEntity delete() {
        return functionRepository.delete();
    }
}
