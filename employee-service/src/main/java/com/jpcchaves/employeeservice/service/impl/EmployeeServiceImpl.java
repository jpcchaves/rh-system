package com.jpcchaves.employeeservice.service.impl;

import com.jpcchaves.employeeservice.dto.APIResponseDto;
import com.jpcchaves.employeeservice.dto.DepartmentDto;
import com.jpcchaves.employeeservice.dto.EmployeeDto;
import com.jpcchaves.employeeservice.entity.Employee;
import com.jpcchaves.employeeservice.repository.EmployeeRepository;
import com.jpcchaves.employeeservice.service.APIClient;
import com.jpcchaves.employeeservice.service.EmployeeService;
import com.jpcchaves.employeeservice.utils.MapperUtils;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository repository;
    private final MapperUtils mapperUtils;
    private final WebClient webClient;
    private final APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository repository,
                               MapperUtils mapperUtils,
                               WebClient webClient,
                               APIClient apiClient) {
        this.repository = repository;
        this.mapperUtils = mapperUtils;
        this.webClient = webClient;
        this.apiClient = apiClient;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = mapperUtils.parseObject(employeeDto, Employee.class);
        Employee newEmployee = repository.save(employee);
        return mapperUtils.parseObject(newEmployee, EmployeeDto.class);
    }

    @Override
//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getById(Long employeeId) {

        LOGGER.info("inside getEmployeeById method");

        Employee employee = repository.findById(employeeId).orElseThrow(() -> new RuntimeException("Could not find employee"));
        DepartmentDto departmentDto = webClient
                .get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        EmployeeDto employeeDto = mapperUtils.parseObject(employee, EmployeeDto.class);

        return new APIResponseDto(
                departmentDto,
                employeeDto
        );
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

        LOGGER.info("inside fallback method");

        Employee employee = repository.findById(employeeId).orElseThrow(() -> new RuntimeException("Could not find employee"));
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentDescription("Research and Development Department");
        departmentDto.setDepartmentCode("RD001");

        EmployeeDto employeeDto = mapperUtils.parseObject(employee, EmployeeDto.class);

        return new APIResponseDto(
                departmentDto,
                employeeDto
        );
    }
}
