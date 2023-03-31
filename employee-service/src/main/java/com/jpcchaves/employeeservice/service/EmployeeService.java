package com.jpcchaves.employeeservice.service;

public interface EmployeeService<T> {
    T create(T employeeDto);
}
