package com.example.emploee.repository;

import com.example.emploee.model.ModelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<ModelEmployee,Integer> {


    Optional<ModelEmployee> findByUsername(String username);


    List<ModelEmployee> findModelEmployeeByCompanyId(int modelCompanyId);
}
