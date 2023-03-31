package com.jpcchaves.employeeservice.service.impl;

import com.jpcchaves.employeeservice.dto.EmployeeDto;
import com.jpcchaves.employeeservice.entity.Employee;
import com.jpcchaves.employeeservice.repository.EmployeeRepository;
import com.jpcchaves.employeeservice.service.EmployeeService;
import com.jpcchaves.employeeservice.utils.MapperUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final MapperUtils mapperUtils;

    public EmployeeServiceImpl(EmployeeRepository repository, MapperUtils mapperUtils) {
        this.repository = repository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = mapperUtils.parseObject(employeeDto, Employee.class);
        Employee newEmployee = repository.save(employee);
        return mapperUtils.parseObject(newEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getById(Long employeeId) {
        Employee employee = repository.findById(employeeId).orElseThrow(() -> new RuntimeException("Could not find employee"));
        return mapperUtils.parseObject(employee, EmployeeDto.class);
    }
}
