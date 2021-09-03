package com.example.emploee.repository;

import com.example.emploee.model.ModelCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<ModelCompany,Integer> {
}
