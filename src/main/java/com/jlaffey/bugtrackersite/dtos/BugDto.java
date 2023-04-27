package com.jlaffey.bugtrackersite.dtos;

import com.jlaffey.bugtrackersite.models.Project;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BugDto {
    private Long id;
    private String title;
    private String description;
    private Project project;
}
