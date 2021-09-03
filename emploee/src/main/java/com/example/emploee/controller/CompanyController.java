package com.example.emploee.controller;

import com.example.emploee.model.ModelCompany;
import com.example.emploee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    @GetMapping("/company")
    public String company(ModelMap modelMap){
        List<ModelCompany> all = companyRepository.findAll();
        modelMap.addAttribute("company", all);
      //  System.out.println(all);

        return "company";
    }
    @GetMapping("/addCompany")
    public String addCompany(){
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String postAddCompany(@ModelAttribute ModelCompany company, @RequestParam("picture") MultipartFile multipartFile) throws IOException {

        String picUrl = System.currentTimeMillis()+"_"+ multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File(uploadDir+File.separator+picUrl));
        company.setPicUrl(picUrl);
        companyRepository.save(company);
        return "redirect:/company";
//    }
//    @GetMapping("/deleteCompany/{id}")
//    public String deleteCompany(@PathVariable("id")int id){
//        System.out.println("egav xosqi");
//        return "redirect:/company";
    }
    @GetMapping("/deleteCompany")
    public String delete(@RequestParam("id")int id){
        companyRepository.deleteById(id);
        return "redirect:/company";
    }


}
