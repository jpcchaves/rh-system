package com.jpcchaves.employeeservice.service.impl;

import com.jpcchaves.employeeservice.dto.APIResponseDto;
import com.jpcchaves.employeeservice.dto.DepartmentDto;
import com.jpcchaves.employeeservice.dto.EmployeeDto;
import com.jpcchaves.employeeservice.entity.Employee;
import com.jpcchaves.employeeservice.repository.EmployeeRepository;
import com.jpcchaves.employeeservice.service.APIClient;
import com.jpcchaves.employeeservice.service.EmployeeService;
import com.jpcchaves.employeeservice.utils.MapperUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final MapperUtils mapperUtils;
    private final APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository repository,
                               MapperUtils mapperUtils,
                               APIClient apiClient) {
        this.repository = repository;
        this.mapperUtils = mapperUtils;
        this.apiClient = apiClient;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = mapperUtils.parseObject(employeeDto, Employee.class);
        Employee newEmployee = repository.save(employee);
        return mapperUtils.parseObject(newEmployee, EmployeeDto.class);
    }

    @Override
    public APIResponseDto getById(Long employeeId) {
        Employee employee = repository.findById(employeeId).orElseThrow(() -> new RuntimeException("Could not find employee"));
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = mapperUtils.parseObject(employee, EmployeeDto.class);

        return new APIResponseDto(
                departmentDto,
                employeeDto
        );
    }
}
