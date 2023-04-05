package com.jpcchaves.organizationservice.service.impl;

import com.jpcchaves.organizationservice.dto.OrganizationDto;
import com.jpcchaves.organizationservice.entity.Organization;
import com.jpcchaves.organizationservice.repository.OrganizationRepository;
import com.jpcchaves.organizationservice.service.OrganizationService;
import com.jpcchaves.organizationservice.utils.MapperUtils;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;
    private final MapperUtils mapper;

    public OrganizationServiceImpl(OrganizationRepository repository, MapperUtils mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public OrganizationDto create(OrganizationDto organizationDto) {
        Organization organization = mapper.parseObject(organizationDto, Organization.class);

        Organization savedOrganization = repository.save(organization);

        return mapper.parseObject(savedOrganization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getByOrganizationCode(String organizationCode) {
        Organization organization = repository
                .findOrganizationByOrganizationCode(organizationCode)
                .orElseThrow(() -> new RuntimeException("Could not find organization"));

        return mapper.parseObject(organization, OrganizationDto.class);
    }
}
