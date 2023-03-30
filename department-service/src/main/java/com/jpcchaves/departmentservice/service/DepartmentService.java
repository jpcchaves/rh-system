package com.jpcchaves.departmentservice.service;


import com.jpcchaves.departmentservice.dto.DepartmentDto;
import com.jpcchaves.departmentservice.repository.DepartmentRepository;

public interface DepartmentService {
    DepartmentDto save(DepartmentDto department);
}
