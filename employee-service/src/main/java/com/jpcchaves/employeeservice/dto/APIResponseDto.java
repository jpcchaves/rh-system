package com.jpcchaves.employeeservice.dto;

public class APIResponseDto {
    private DepartmentDto department;
    private EmployeeDto employee;

    public APIResponseDto() {
    }

    public APIResponseDto(DepartmentDto department, EmployeeDto employee) {
        this.department = department;
        this.employee = employee;
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
}
