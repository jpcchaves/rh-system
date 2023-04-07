package com.jpcchaves.departmentservice.controller;

import com.jpcchaves.departmentservice.dto.DepartmentDto;
import com.jpcchaves.departmentservice.service.DepartmentService;
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
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Operation(
            summary = "Create a Department",
            description = "Create a Department by passing a JSON representation of the Department"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(departmentDto));
    }

    @Operation(
            summary = "Get a Department",
            description = "get a Department by passing a department code"

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 OK"
    )
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getByDepartmentCode(@PathVariable("department-code") String departmentCode) {
        return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentCode));
    }


}
