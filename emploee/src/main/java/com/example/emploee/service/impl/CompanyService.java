package com.example.emploee.service.impl;

import com.example.emploee.model.ModelCompany;
import com.example.emploee.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor


public class CompanyService {

private final CompanyRepository companyRepository;

    public ModelCompany getModelCompanyById(int modelCompanyId){
        return companyRepository.getById(modelCompanyId);
    }

    public void save(ModelCompany company){
        companyRepository.save(company);
    }
}
