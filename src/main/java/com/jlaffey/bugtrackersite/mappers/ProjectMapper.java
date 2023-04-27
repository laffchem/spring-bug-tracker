package com.jlaffey.bugtrackersite.mappers;

import com.jlaffey.bugtrackersite.dtos.ProjectDto;
import com.jlaffey.bugtrackersite.models.Project;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.jlaffey.bugtrackersite.mappers.BugMapper.mapToBugDto;

public class ProjectMapper {
    public static Project mapToProject(ProjectDto project) {
        Project projectDto = Project.builder()
                .id(project.getId())
                .name(project.getName())
                .organization(project.getOrganization())
                .build();
        return projectDto;

    }

    public static ProjectDto mapToProjectDto(Project project) {
        ProjectDto projectDto = ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .organization(project.getOrganization())
                .bugs(project.getBugs().stream().map((bug) -> mapToBugDto(Optional.ofNullable(bug))).collect(Collectors.toList()))
                .build();
    return projectDto;
    }
}
