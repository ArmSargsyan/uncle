package com.example.emploee.service.impl;

import com.example.emploee.model.ModelEmployee;
import com.example.emploee.repository.EmployeeRepository;
import com.example.emploee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<ModelEmployee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(ModelEmployee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);

    }
}
