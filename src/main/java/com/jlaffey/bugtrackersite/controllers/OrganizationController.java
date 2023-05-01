package com.jlaffey.bugtrackersite.controllers;

import com.jlaffey.bugtrackersite.dtos.OrganizationDto;
import com.jlaffey.bugtrackersite.dtos.ProjectDto;
import com.jlaffey.bugtrackersite.models.Organization;
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
public class OrganizationController {
    private ProjectService projectService;
    private OrganizationService organizationService;
    private BugService bugService;

    @Autowired
    public OrganizationController(ProjectService projectService, OrganizationService organizationService, BugService bugService) {
        this.projectService = projectService;
        this.organizationService = organizationService;
        this.bugService = bugService;
    }

    @GetMapping("/organizations")
    public String organizationList(Model model) {
        List<OrganizationDto> organizations = organizationService.findAllOrganizations();
        model.addAttribute("organizations", organizations);
        return "organizations/organizations";
    }

    @GetMapping("/organizations/new")
    public String getOrganizationCreateForm(Model model) {
        Organization organization = new Organization();
        model.addAttribute("organization", organization);
        return "organizations/organization-create";
    }


    @PostMapping("/organizations/new")
    public String createOrganization(@Valid @ModelAttribute("organization") OrganizationDto organizationDto, Model model, BindingResult result) {
        if(result.hasErrors()) {
            model.addAttribute("organization", organizationDto);
            return "organizations/organization-create";
        }
            organizationService.saveOrganization(organizationDto);
            return "redirect:/organizations";
    }
}
