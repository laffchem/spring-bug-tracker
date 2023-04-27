package com.jlaffey.bugtrackersite.services;

import com.jlaffey.bugtrackersite.dtos.OrganizationDto;
import com.jlaffey.bugtrackersite.dtos.ProjectDto;
import com.jlaffey.bugtrackersite.models.Organization;
import com.jlaffey.bugtrackersite.models.Project;

import java.util.List;

public interface OrganizationService {
    List<OrganizationDto> findAllOrganizations();
    Organization saveOrganization(OrganizationDto organizationDto);
    OrganizationDto findOrganizationById(Long organizationId);
    void updateOrganization(OrganizationDto organizationDto);

    void delete(Long organizationId);
}
