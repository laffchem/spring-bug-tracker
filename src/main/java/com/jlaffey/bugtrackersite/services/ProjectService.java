package com.jlaffey.bugtrackersite.services;

import com.jlaffey.bugtrackersite.dtos.ProjectDto;
import com.jlaffey.bugtrackersite.models.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAllProjects();
    Project saveProject(ProjectDto projectDto);
    ProjectDto findProjectById(Long projectId);
    void updateProject(ProjectDto projectDto);

    void delete(Long projectId);

}
