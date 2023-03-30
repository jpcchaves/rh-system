package com.jpcchaves.departmentservice.service.impl;

import com.jpcchaves.departmentservice.dto.DepartmentDto;
import com.jpcchaves.departmentservice.repository.DepartmentRepository;
import com.jpcchaves.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartmentDto save(DepartmentDto department) {
        return null;
    }
}
