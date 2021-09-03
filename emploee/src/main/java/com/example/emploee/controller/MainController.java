package com.example.emploee.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;

@Controller
public class MainController {


    @GetMapping("/")
    public String main(@AuthenticationPrincipal Principal principal, Model modelMap) {
//        String username = null;
//        if (principal != null){
//            username = principal.getName();
            modelMap.addAttribute("username", principal);
        return "/index";
               }



    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/403")
    public String forbiddenPage() {
        return "403";
    }

    @Value("${upload.dir}")
    private String uploadDir;

    @GetMapping(value = "/image")
    public @ResponseBody
    byte[] getImage(@RequestParam("picUrl") String picUrl) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + picUrl);
    return IOUtils.toByteArray(in);
    }
}
