package com.jlaffey.bugtrackersite.controllers;

import com.jlaffey.bugtrackersite.dtos.BugDto;
import com.jlaffey.bugtrackersite.dtos.ProjectDto;
import com.jlaffey.bugtrackersite.models.Bug;
import com.jlaffey.bugtrackersite.services.BugService;
import com.jlaffey.bugtrackersite.services.OrganizationService;
import com.jlaffey.bugtrackersite.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BugController {

    private BugService bugService;
    private OrganizationService organizationService;
    private ProjectService projectService;

    @Autowired
    public BugController(BugService bugService, OrganizationService organizationService, ProjectService projectService) {
        this.bugService = bugService;
        this.organizationService = organizationService;
        this.projectService = projectService;
    }
//    Get list of bugs
    @GetMapping("/bugs")
    public String listBugs(Model model) {
        List<BugDto> bugs = bugService.findAllBugs();
        model.addAttribute("bugs", bugs);
        return "bugs/bugs";
    }
//List bugs in project
@GetMapping("/{projectId}/bugs")
public String getBugsByProjectId(@PathVariable Long projectId, Model model) {
    ProjectDto projectDto = projectService.findProjectById(projectId);
    List<BugDto> bugs = projectDto.getBugs();
    model.addAttribute("bugs", bugs);
    return "bugs/project-buglist";
}
//Get the bug creation form
    @GetMapping("/bugs/{projectId}/new")
    public String createBugForm(@PathVariable("projectId") Long projectId, Model model) {
        Bug bug = new Bug();
        model.addAttribute("projectId", projectId);
        model.addAttribute("bug", bug);
        return "bugs/bug-create";
    }

//    Post bug creation form to database
    @PostMapping("/bugs/{projectId}")
    public String createBug(@Valid @PathVariable("projectId") Long projectId, @ModelAttribute("bug") BugDto bugDto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("bug", bugDto);
            return "bugs/bug-create";
        }
        bugService.createBug(projectId, bugDto);
        return "redirect:/" + projectId + "/bugs";

    }

    //    Get the bug edit form
    @GetMapping("/bugs/{bugId}/edit")
    public String editBugForm(@PathVariable("bugId") Long bugId, Model model) {
        BugDto bug = bugService.findBugById(bugId);
        model.addAttribute("bug", bug);
        return "bugs/edit-bugs";
    }

//    Post the bug edit form
    @PostMapping("/bugs/{bugId}/edit")
    public String submitBugEditForm(@Valid @PathVariable("bugId") Long bugId, @ModelAttribute("bug") BugDto bug, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("bug", bug);
            return "bugs/edit-bugs";
        }
        BugDto bugDto = bugService.findBugById(bugId);
        bug.setId(bugId);
        bug.setProject(bugDto.getProject());
        bugService.updateBug(bug);
        return "redirect:/bugs";
    }

//    Delete Bug
    @GetMapping("/bugs/{bugId}/delete")
    public String deleteBug(@PathVariable("bugId") Long bugId) {
//        bugService.findBugById(bugId);
        bugService.deleteBug(bugId);
        return "redirect:/bugs";
    }


}
