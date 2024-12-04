package com.javaexperts.ems.service;

import com.javaexperts.ems.dto.EmployeeDto;
import com.javaexperts.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employee);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto>  getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(long employeeId);
}
