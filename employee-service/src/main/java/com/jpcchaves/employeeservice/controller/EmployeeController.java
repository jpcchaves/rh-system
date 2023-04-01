package com.jpcchaves.employeeservice.controller;

import com.jpcchaves.employeeservice.dto.APIResponseDto;
import com.jpcchaves.employeeservice.dto.EmployeeDto;
import com.jpcchaves.employeeservice.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employeeDto));
    }

    @GetMapping("/{employee-id}")
    public ResponseEntity<APIResponseDto> getById(@PathVariable(name = "employee-id") Long employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(employeeId));
    }
}
