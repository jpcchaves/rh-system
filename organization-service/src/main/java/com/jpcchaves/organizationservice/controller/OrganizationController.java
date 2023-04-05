package com.jpcchaves.organizationservice.controller;

import com.jpcchaves.organizationservice.dto.OrganizationDto;
import com.jpcchaves.organizationservice.entity.Organization;
import com.jpcchaves.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrganizationDto> create(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto createdOrganization = service.create(organizationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganization);
    }
}
