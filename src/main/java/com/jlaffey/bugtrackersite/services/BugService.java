package com.jlaffey.bugtrackersite.services;

import com.jlaffey.bugtrackersite.dtos.BugDto;

import java.util.List;

public interface BugService {
    List<BugDto> findAllBugs();
    void createBug(Long projectId, BugDto bugDto);

    BugDto findBugById(Long bugId);

    void updateBug(BugDto bugDto);

    void deleteBug(Long bugId);



}
