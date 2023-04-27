package com.jlaffey.bugtrackersite.mappers;

import com.jlaffey.bugtrackersite.dtos.BugDto;
import com.jlaffey.bugtrackersite.models.Bug;

import java.util.Optional;

public class BugMapper {
    public static Bug mapToBug(BugDto bugDto) {
        return Bug.builder()
                .id(bugDto.getId())
                .title(bugDto.getTitle())
                .description(bugDto.getDescription())
                .project(bugDto.getProject())
                .build();
    }

    public static BugDto mapToBugDto(Optional<Bug> bug) {
        Bug bugObject = bug.orElseThrow(() -> new RuntimeException("Bug not found"));
        return BugDto.builder()
                .id(bugObject.getId())
                .title(bugObject.getTitle())
                .description(bugObject.getDescription())
                .project(bugObject.getProject())
                .build();
    }
}
