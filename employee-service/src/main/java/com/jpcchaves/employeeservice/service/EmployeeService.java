package com.jpcchaves.employeeservice.service;

import com.jpcchaves.employeeservice.dto.APIResponseDto;
import com.jpcchaves.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);
    APIResponseDto getById(Long employeeId);
}
