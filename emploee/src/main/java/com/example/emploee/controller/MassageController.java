package com.example.emploee.controller;

import com.example.emploee.model.MassageModel;
import com.example.emploee.model.ModelEmployee;
import com.example.emploee.security.CurrentUser;
import com.example.emploee.service.EmployeeService;
import com.example.emploee.service.impl.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//@RequiredArgsConstructor
public class MassageController {

    @Autowired
    private  EmployeeService employeeService;
   @Autowired
    private  MassageService massageService;


    @GetMapping("/formMessage")
    public String getAllEmployees(ModelMap modelMap) {
        List<ModelEmployee> allEmployees = employeeService.findAllEmployees();
        modelMap.addAttribute("employee", allEmployees);
        return "formMassage";
    }

    @GetMapping("/myAllMassages")
    public String getAllMassages(ModelMap modelMap, @AuthenticationPrincipal CurrentUser principal) {

        List<MassageModel> allMassages = massageService.findAllMassagesByToId(principal.getUser().getId());
        modelMap.addAttribute("massages", allMassages);
        return "myAllMassages";

   }


    @PostMapping("/formMessage")
    public String sendMassage(@ModelAttribute MassageModel massage, @AuthenticationPrincipal CurrentUser principal){
        massage.setFromEmployee(principal.getUser());
        massageService.saveMassage(massage);
        return "redirect:/employee";
    }

}
