package com.jlaffey.bugtrackersite.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrganizationDto {
    private Long id;
    private String name;
    private List<ProjectDto> projects;
}
