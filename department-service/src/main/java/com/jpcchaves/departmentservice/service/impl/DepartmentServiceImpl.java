package com.jpcchaves.departmentservice.service.impl;

import com.jpcchaves.departmentservice.dto.DepartmentDto;
import com.jpcchaves.departmentservice.entity.Department;
import com.jpcchaves.departmentservice.repository.DepartmentRepository;
import com.jpcchaves.departmentservice.service.DepartmentService;
import com.jpcchaves.departmentservice.utils.MapperUtils;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository repository;
    private MapperUtils mapperUtils;

    public DepartmentServiceImpl(DepartmentRepository repository, MapperUtils mapperUtils) {
        this.repository = repository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department newDepartment = repository.save(mapperUtils.parseObject(departmentDto, Department.class));
        return mapperUtils.parseObject(newDepartment, DepartmentDto.class);
    }
}
