package com.javaexperts.ems.service;

import com.javaexperts.ems.dto.DepartmentDto;
import com.javaexperts.ems.entity.Department;

import java.util.List;

public interface
DepartmentService {

    Department createDepartment(Department department);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);

    void deleteDepartment(Long departmentId);
}
