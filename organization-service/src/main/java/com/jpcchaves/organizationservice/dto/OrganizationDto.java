package com.jpcchaves.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(
        description = "OrganizationDto Model Information"
)
public class OrganizationDto {
    private Long id;
    @Schema(
            description = "Organization Name",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String organizationName;
    @Schema(
            description = "Organization Description",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String organizationDescription;
    @Schema(
            description = "Organization Code",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String organizationCode;
    private LocalDateTime createdAt;

    public OrganizationDto() {
    }

    public OrganizationDto(Long id, String organizationName, String organizationDescription, String organizationCode, LocalDateTime createdAt) {
        this.id = id;
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
        this.organizationCode = organizationCode;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
