package com.jlaffey.bugtrackersite.services.impl;

import com.jlaffey.bugtrackersite.dtos.ProjectDto;
import com.jlaffey.bugtrackersite.models.Project;
import com.jlaffey.bugtrackersite.repositories.ProjectRepository;
import com.jlaffey.bugtrackersite.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.jlaffey.bugtrackersite.mappers.ProjectMapper.mapToProject;
import static com.jlaffey.bugtrackersite.mappers.ProjectMapper.mapToProjectDto;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> findAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(project -> mapToProjectDto(project)).collect(Collectors.toList());
    }

    @Override
    public Project saveProject(ProjectDto projectDto) {
        Project project = mapToProject(projectDto);
        return projectRepository.save(project);
    }

    @Override
    public ProjectDto findProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId).get();
        return mapToProjectDto(project);
    }

    @Override
    public void updateProject(ProjectDto projectDto) {
        Project project = mapToProject(projectDto);
        projectRepository.save(project);

    }

    @Override
    public void delete(Long projectId) {
        projectRepository.deleteById(projectId);

    }
}
