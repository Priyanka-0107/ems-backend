package com.javaexperts.ems.service.impl;

import com.javaexperts.ems.dto.DepartmentDto;
import com.javaexperts.ems.entity.Department;
import com.javaexperts.ems.exception.ResourceNotFoundException;
import com.javaexperts.ems.mapper.DepartmentMapper;
import com.javaexperts.ems.repository.DepartmentRepository;
import com.javaexperts.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return (departmentRepository.save(department));
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
       Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department does not exist a given id: " + departmentId)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department does not exist a given id: " + departmentId)
        );

        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        department.setDepartmentName(updatedDepartment.getDepartmentName());

        Department department1 = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(department1);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department does not exists with given id: " + departmentId)
        );
        departmentRepository.deleteById(departmentId);
    }
}
