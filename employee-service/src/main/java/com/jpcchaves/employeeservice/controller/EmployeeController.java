package com.jpcchaves.employeeservice.controller;

import com.jpcchaves.employeeservice.dto.APIResponseDto;
import com.jpcchaves.employeeservice.dto.EmployeeDto;
import com.jpcchaves.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - DepartmentController",
        description = "Department Controller for Department Services"
)
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "Creates an Employee",
            description = "Creates an Employee by passing a JSON representation of the Employee"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employeeDto));
    }

    @Operation(
            summary = "Gets an Employee",
            description = "Gets an Employee by passing an Employee ID"

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 OK"
    )
    @GetMapping("/{employee-id}")
    public ResponseEntity<APIResponseDto> getById(@PathVariable(name = "employee-id") Long employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(employeeId));
    }
}
