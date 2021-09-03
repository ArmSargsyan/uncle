package com.example.emploee.controller;

import com.example.emploee.model.ModelCompany;
import com.example.emploee.model.ModelEmployee;
import com.example.emploee.repository.CompanyRepository;
import com.example.emploee.repository.EmployeeRepository;
import com.example.emploee.security.CurrentUser;
import com.example.emploee.service.EmployeeService;
import com.example.emploee.service.impl.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public String employee(@AuthenticationPrincipal CurrentUser principal, ModelMap modelMap) {
        List<ModelEmployee> all = employeeRepository.findModelEmployeeByCompanyId(principal.getUser().getCompany().getId());
        modelMap.addAttribute("employee", all);

        return "employee";
    }
    @GetMapping("/employeeAdmin")
    public String employeeAdmin(ModelMap modelMap){
        List<ModelEmployee> all = employeeService.findAllEmployees();
        modelMap.addAttribute("employee",all);
        return "employee";
    }
    @GetMapping("adminPanel")
    public void adPanel(){

    }


    @GetMapping("/employee/add")
    public String addEmployee(ModelMap modelMap) {
        List<ModelCompany> all = companyRepository.findAll();
        modelMap.addAttribute("company", all);
        return "addEmployee";
    }

    @PostMapping("/employee/add")
    public String addEmployeeList(@ModelAttribute ModelEmployee employee) {
        Optional<ModelEmployee> byUsername = employeeRepository.findByUsername(employee.getUsername());
        if (byUsername.isPresent()) {
            return "redirect:/?msg=User already exists";
        }

        // System.out.println(employee);
        employeeService.addEmployee(employee);
        ModelCompany modelCompany = companyService.getModelCompanyById(employee.getCompany().getId());
        modelCompany.setSize(modelCompany.getSize() +1);
        companyService.save(modelCompany);
        return "redirect:/employee";
    }
}
