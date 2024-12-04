package com.javaexperts.ems.controller;


import com.javaexperts.ems.dto.DepartmentDto;
import com.javaexperts.ems.entity.Department;
import com.javaexperts.ems.mapper.DepartmentMapper;
import com.javaexperts.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<Department> createEmployee(@RequestBody DepartmentDto departmentDto){
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    //build get department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    // Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>>  getAllDeparments(){
        List<DepartmentDto> departmentList = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentList);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto updatedepartment) {
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedepartment);
        return ResponseEntity.ok(departmentDto);
    }

     @DeleteMapping("{id}")
     public ResponseEntity<String> deletedepartment(@PathVariable("id") Long departmentId){
            departmentService.deleteDepartment(departmentId);
            return ResponseEntity.ok("Department with id : "+ departmentId +" deleted successfully!.");
        }



}
