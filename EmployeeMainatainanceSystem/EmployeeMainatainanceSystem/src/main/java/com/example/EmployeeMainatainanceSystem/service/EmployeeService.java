package com.example.EmployeeMainatainanceSystem.service;

import com.example.EmployeeMainatainanceSystem.entity.Employee;
import java.util.List;

public interface EmployeeService {

    // Save a new employee
    Employee saveEmployee(Employee employee);

    // Fetch all employees
    List<Employee> fetchAllEmployees();

    // Get employee by ID
    Employee getEmployeeById(Long id);

    // Update employee by ID
    Employee updateEmployeeById(Long id, Employee employee);

    // Delete employee by ID
    String deleteEmployeeById(Long id);
}
