package com.faasj.gateway.service;

import com.faasj.gateway.entity.FunctionEntity;
import com.faasj.gateway.repository.FunctionRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FunctionService {

    @Autowired
    private FunctionRepositoryInterface functionRepository;

    public void delete(UUID functionId) {
        functionRepository.deleteById(functionId);
    }

    public void save(FunctionEntity functionEntity) {
        functionRepository.save(functionEntity);
    }

}
