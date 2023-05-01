package com.jlaffey.bugtrackersite.controllers;

import com.jlaffey.bugtrackersite.dtos.OrganizationDto;
import com.jlaffey.bugtrackersite.dtos.ProjectDto;
import com.jlaffey.bugtrackersite.models.Project;
import com.jlaffey.bugtrackersite.services.BugService;
import com.jlaffey.bugtrackersite.services.OrganizationService;
import com.jlaffey.bugtrackersite.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjectController {
    private ProjectService projectService;
    private OrganizationService organizationService;
    private BugService bugService;

    @Autowired
    public ProjectController(ProjectService projectService, OrganizationService organizationService, BugService bugService) {
        this.projectService = projectService;
        this.organizationService = organizationService;
        this.bugService = bugService;
    }

    //  All Projects
    @GetMapping("/projects")
    public String listProjects(Model model) {
        List<ProjectDto> projects = projectService.findAllProjects();
        model.addAttribute("projects", projects);
        return "projects/projects";
    }

    //    Projects in an organization
    @GetMapping("/{organizationId}/projects")
    public String getProjectsByOrganizationId(@PathVariable("organizationId") Long organizationId, Model model) {
        OrganizationDto organizationDto = organizationService.findOrganizationById(organizationId);
        List<ProjectDto> projects = organizationDto.getProjects();
        model.addAttribute("projects", projects);
        return "projects/organization-projectlist";
    }

    //    Create Project Form
    @GetMapping("/projects/{organizationId}/new")
    public String getProjectCreateForm(Model model, @PathVariable String organizationId) {
        Project project = new Project();
        model.addAttribute("organizationId", organizationId);
        model.addAttribute("project", project);
        return "projects/project-create";
    }

    @PostMapping("/projects/{organizationId}")
    public String saveProject(@Valid @ModelAttribute("project") ProjectDto projectDto, BindingResult result, Model model, @PathVariable String organizationId) {
        if (result.hasErrors()) {
            model.addAttribute("project", projectDto);
            return "projects/project-create";
        }
        projectService.saveProject(projectDto);
        return "redirect:/" + organizationId + "/projects";
    }

    @GetMapping("/projects/{projectId}/edit")
    public String editProjectForm(@PathVariable("projectId") Long projectId, Model model) {
        ProjectDto project = projectService.findProjectById(projectId);
        model.addAttribute("project", project);
        return "projects/project-edit";
    }

    //    Edit project
    @PostMapping("/projects/{projectId}/edit")
    public String editProject(@Valid @PathVariable("projectId") Long projectId, @ModelAttribute("project") ProjectDto project, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("project", project);
            return "projects/project-edit";
        }
        ProjectDto projectDto = projectService.findProjectById(projectId);
        project.setId(projectId);
        project.setOrganization(projectDto.getOrganization());
        projectService.updateProject(project);
        return "redirect:/projects";
    }

    //    Delete Project
    @GetMapping("/projects/{projectId}/delete")
    public String deleteProject(@PathVariable("projectId") Long projectId) {
        projectService.delete(projectId);
        return "redirect:/projects";
    }
}
