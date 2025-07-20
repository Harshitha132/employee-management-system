package com.example.EmployeeMainatainanceSystem.controller;

import com.example.EmployeeMainatainanceSystem.entity.Employee;
import com.example.EmployeeMainatainanceSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Allow cross-origin requests from any domain (for development)
@RestController
@RequestMapping("/api/employee") // Base path for all employee-related APIs
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * POST /api/employee
     * Create a new employee
     */
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * GET /api/employee
     * Fetch all employees
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    /**
     * GET /api/employee/{id}
     * Get employee by ID
     */
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    /**
     * PUT /api/employee/{id}
     * Update employee by ID
     */
    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    /**
     * DELETE /api/employee/{id}
     * Delete employee by ID
     */
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}
