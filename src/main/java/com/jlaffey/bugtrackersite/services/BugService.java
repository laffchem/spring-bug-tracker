package com.jlaffey.bugtrackersite.services;

import com.jlaffey.bugtrackersite.dtos.BugDto;
import com.jlaffey.bugtrackersite.models.Bug;

import java.util.List;

public interface BugService {
    List<BugDto> findAllBugs(BugDto bugDto);
    void createBug(Long projectId, BugDto bugDto);

    BugDto findBugById(Long bugId);

    void updateBug(BugDto bugDto);

    void deleteBug(Long bugId);



}
