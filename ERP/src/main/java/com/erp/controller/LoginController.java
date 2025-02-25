package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.erp.admin.entity.AdminEntity;

@Controller
public class LoginController {
	
	@GetMapping({"/",""})
    public String getLogin(Model model) { 
		model.addAttribute("loginForm",new AdminEntity());
        return "login";
    }	
	
}
