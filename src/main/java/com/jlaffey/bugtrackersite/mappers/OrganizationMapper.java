package com.jlaffey.bugtrackersite.mappers;

import com.jlaffey.bugtrackersite.dtos.OrganizationDto;
import com.jlaffey.bugtrackersite.models.Organization;
import com.jlaffey.bugtrackersite.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.jlaffey.bugtrackersite.mappers.ProjectMapper.mapToProjectDto;


public class OrganizationMapper {
    public static Organization mapToOrganization(OrganizationDto organization) {
        Organization organizationDto = Organization.builder()
                .id(organization.getId())
                .name(organization.getName())
                .build();
        return organizationDto;
    }

    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        OrganizationDto organizationDto = OrganizationDto.builder()
                .id(organization.getId())
                .name(organization.getName())
                .projects(organization.getProjects().stream().map((project) -> mapToProjectDto(project)).collect(Collectors.toList()))
                .build();
        return organizationDto;

    }
}
