package com.example.emploee.service;

import com.example.emploee.model.ModelEmployee;

import java.util.List;

public interface EmployeeService {

   List<ModelEmployee> findAllEmployees();

    void    addEmployee(ModelEmployee employee);
}
