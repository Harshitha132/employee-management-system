package com.example.EmployeeMainatainanceSystem.service;

import com.example.EmployeeMainatainanceSystem.entity.Employee;
import com.example.EmployeeMainatainanceSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Save a new employee
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get a single employee by ID
    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null); // returns null if not found
    }

    // Update employee fields by ID
    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee originalEmployee = optionalEmployee.get();

            // Update name if not null or empty
            if (Objects.nonNull(employee.getName()) && !employee.getName().trim().isEmpty()) {
                originalEmployee.setName(employee.getName());
            }

            // Update DOJ if not null or empty
            if (Objects.nonNull(employee.getDoj()) && !employee.getDoj().trim().isEmpty()) {
                originalEmployee.setDoj(employee.getDoj());
            }

            // Update status if valid (assuming -1 means invalid)
            if (employee.getStatus() != -1) {
                originalEmployee.setStatus(employee.getStatus());
            }

            // Update salary if not 0
            if (employee.getSalary() != 0) {
                originalEmployee.setSalary(employee.getSalary());
            }

            // Save updated employee
            return employeeRepository.save(originalEmployee);
        }

        // Return null if employee not found
        return null;
    }

    // Delete employee by ID
    @Override
    public String deleteEmployeeById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "✅ Employee deleted successfully.";
        }
        return "❌ Employee with this ID does not exist.";
    }
}
