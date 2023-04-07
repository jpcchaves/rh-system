package com.jpcchaves.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "EmployeeDto Model Information"
)
public class EmployeeDto {
    private Long id;
    @Schema(
            description = "Employee First Name",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String firstName;
    @Schema(
            description = "Employee Last Name",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String lastName;
    @Schema(
            description = "Employee Email",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String email;
    @Schema(
            description = "Employee Department",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String departmentCode;
    @Schema(
            description = "Employee Organization",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String organizationCode;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstName, String lastName, String email, String departmentCode, String organizationCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentCode = departmentCode;
        this.organizationCode = organizationCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }
}
