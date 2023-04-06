package com.jpcchaves.employeeservice.dto;

public class APIResponseDto {
    private DepartmentDto department;
    private EmployeeDto employee;
    private OrganizationDto organization;

    public APIResponseDto() {
    }

    public APIResponseDto(DepartmentDto department, EmployeeDto employee, OrganizationDto organization) {
        this.department = department;
        this.employee = employee;
        this.organization = organization;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }
}
