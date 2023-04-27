package com.jlaffey.bugtrackersite.services.impl;

import com.jlaffey.bugtrackersite.dtos.OrganizationDto;
import com.jlaffey.bugtrackersite.models.Organization;
import com.jlaffey.bugtrackersite.repositories.OrganizationRepository;
import com.jlaffey.bugtrackersite.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.jlaffey.bugtrackersite.mappers.OrganizationMapper.mapToOrganization;
import static com.jlaffey.bugtrackersite.mappers.OrganizationMapper.mapToOrganizationDto;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<OrganizationDto> findAllOrganizations() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizations.stream().map((organization) -> mapToOrganizationDto(organization)).collect(Collectors.toList());
    }

    @Override
    public Organization saveOrganization(OrganizationDto organizationDto) {
        Organization organization = mapToOrganization(organizationDto);
        return organizationRepository.save(organization);
    }

    @Override
    public OrganizationDto findOrganizationById(Long organizationId) {
        Organization organization = organizationRepository.findById(organizationId).get();
        return mapToOrganizationDto(organization);
    }

    @Override
    public void updateOrganization(OrganizationDto organizationDto) {
        Organization organization = mapToOrganization(organizationDto);
        organizationRepository.save(organization);
    }

    public void delete(Long organizationId) {
        organizationRepository.deleteById(organizationId);
    }
}
