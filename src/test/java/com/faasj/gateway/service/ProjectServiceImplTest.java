package com.faasj.gateway.service;

import com.faasj.gateway.GatewayApplicationTests;
import com.faasj.gateway.dto.ProjectDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectServiceImplTest extends GatewayApplicationTests {

    @Autowired
    ProjectService projectService;

    @Test
    void testCreateProject() {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName("testCreateProject");
        projectDto.setOwnerId(UUID.fromString("3fa85f64-2222-4562-b3fc-2c963f66afa6"));
        projectDto.setTags(Map.of("1","2"));

        projectService.save(projectDto);
        Assertions.assertEquals(2, projectService.getAll().size());

        ProjectDto projectDto2 = new ProjectDto();
        projectDto2.setName("testCreateProject2");
        projectDto2.setOwnerId(UUID.fromString("3fa85f64-3333-4562-b3fc-2c963f66afa6"));
        projectDto2.setTags(Map.of("3","4"));

        projectService.save(projectDto2);
        Assertions.assertEquals(3, projectService.getAll().size());
    }

    @Test
    void testGetProjectById() {
        var project = projectService.get(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
        assertTrue(Objects.nonNull(project));
    }

    @Test
    void testGetAllProjects() {
        assertTrue(Objects.nonNull(projectService.getAll()));
    }

    @Test
    void testDeleteProject() {

        ProjectDto projectDto2 = new ProjectDto();
        projectDto2.setName("testCreateProject2");
        projectDto2.setOwnerId(UUID.fromString("3fa85f64-3333-4562-b3fc-2c963f66afa6"));
        projectDto2.setTags(Map.of("3","4"));
        projectService.save(projectDto2);

        List<ProjectDto> projects = projectService.getAll();
        Assertions.assertEquals(2, projects.size());

        projectService.delete(projects.get(1).getProjectId());

        projects = projectService.getAll();

        Assertions.assertEquals(1, projects.size());
    }

    @Test
    void testUpdateProjectById() {

        UUID beforeOwnerId = projectService.get(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")).getOwnerId();

        ProjectDto projectDto2 = new ProjectDto();
        projectDto2.setProjectId(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
        projectDto2.setName("testCreateProject2");
        projectDto2.setOwnerId(UUID.fromString("3fa85f64-1111-2222-b3fc-2c963f66afa6"));
        projectDto2.setTags(Map.of("3","4"));

        projectService.update(projectDto2);

        UUID afterOwnerId = projectService.get(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")).getOwnerId();

        Assertions.assertNotEquals(beforeOwnerId, afterOwnerId);
    }

}
