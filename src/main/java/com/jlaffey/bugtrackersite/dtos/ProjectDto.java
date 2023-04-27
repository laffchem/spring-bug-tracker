package com.jlaffey.bugtrackersite.dtos;

import com.jlaffey.bugtrackersite.models.Organization;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ProjectDto {
    private Long id;
    private String name;
    private Organization organization;
    private List<BugDto> bugs;
}
