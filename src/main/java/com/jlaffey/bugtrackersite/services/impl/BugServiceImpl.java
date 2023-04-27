package com.jlaffey.bugtrackersite.services.impl;

import com.jlaffey.bugtrackersite.dtos.BugDto;
import com.jlaffey.bugtrackersite.models.Bug;
import com.jlaffey.bugtrackersite.models.Project;
import com.jlaffey.bugtrackersite.repositories.BugRepository;
import com.jlaffey.bugtrackersite.repositories.ProjectRepository;
import com.jlaffey.bugtrackersite.services.BugService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jlaffey.bugtrackersite.mappers.BugMapper.mapToBug;
import static com.jlaffey.bugtrackersite.mappers.BugMapper.mapToBugDto;

@Service
public class BugServiceImpl implements BugService {

    private BugRepository bugRepository;
    private ProjectRepository projectRepository;

    public BugServiceImpl(BugRepository bugRepository, ProjectRepository projectRepository) {
        this.bugRepository = bugRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<BugDto> findAllBugs(BugDto bugDto) {
        List<Bug> bugs = bugRepository.findAll();
        return bugs.stream().map((bug) -> mapToBugDto(Optional.ofNullable(bug))).collect(Collectors.toList());
    }

    @Override
    public void createBug(Long projectId, BugDto bugDto) {
        Project project = projectRepository.findById(projectId).get();
        Bug bug = mapToBug(bugDto);
        bug.setProject(project);
        bugRepository.save(bug);
    }

    @Override
    public BugDto findBugById(Long bugId) {
        Optional<Bug> bug = bugRepository.findById(bugId);
        return mapToBugDto(bug);
    }

    @Override
    public void updateBug(BugDto bugDto) {
        Bug bug = mapToBug(bugDto);
        bugRepository.save(bug);
    }

    @Override
    public void deleteBug(Long bugId) {
        bugRepository.deleteById(bugId);
    }
}
