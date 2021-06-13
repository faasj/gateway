package com.faasj.gateway.repository;

import com.faasj.gateway.entity.FunctionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FunctionRepository extends CrudRepository<FunctionEntity, UUID> {
}
