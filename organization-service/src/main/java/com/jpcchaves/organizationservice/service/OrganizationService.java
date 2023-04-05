package com.jpcchaves.organizationservice.service;

import com.jpcchaves.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto create(OrganizationDto organizationDto);
    OrganizationDto getByOrganizationCode(String organizationCode);
}
