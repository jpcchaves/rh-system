package com.jpcchaves.organizationservice.controller;

import com.jpcchaves.organizationservice.dto.OrganizationDto;
import com.jpcchaves.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Organization Service - OrganizationController",
        description = "Organization Controller for Organization Services"
)
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @Operation(
            summary = "Creates an Organization",
            description = "Creates an Organization by passing a JSON representation of the Organization"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> create(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto createdOrganization = service.create(organizationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganization);
    }

    @Operation(
            summary = "Gets an Organization",
            description = "Gets an Employee by passing an Organization Code"

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 OK"
    )
    @GetMapping("/{organization-code}")
    public ResponseEntity<OrganizationDto> getByOrganizationCode(@PathVariable(name = "organization-code")
                                                                 String organizationCode) {
        OrganizationDto organizationDto = service.getByOrganizationCode(organizationCode);
        return ResponseEntity.status(HttpStatus.OK).body(organizationDto);
    }
}
