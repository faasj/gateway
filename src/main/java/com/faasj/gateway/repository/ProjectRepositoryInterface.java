package com.faasj.gateway.repository;

import com.faasj.gateway.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepositoryInterface extends CrudRepository<ProjectEntity, UUID> {
}
