package com.example.emploee.controller;


import com.example.emploee.model.ModelEmployee;
import com.example.emploee.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MainAdvice {

//    @ModelAttribute
//    public void currentUser(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
//        modelMap.addAttribute("currentUser", currentUser.getUser());
//    }

    @ModelAttribute("currentUser")
    public ModelEmployee currentUser(@AuthenticationPrincipal CurrentUser currentUser){
        if (currentUser == null){
            return new ModelEmployee();
        }
        return currentUser.getUser();
    }
}
