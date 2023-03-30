package com.jpcchaves.departmentservice.controller;

import com.jpcchaves.departmentservice.dto.DepartmentDto;
import com.jpcchaves.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(departmentDto));
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getByDepartmentCode(@PathVariable String departmentCode) {
        return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentCode));
    }


}
