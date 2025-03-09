package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.erp.admin.entity.AdminEntity;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@GetMapping({"/",""})
    public String getLogin(Model model) { 
		model.addAttribute("loginForm",new AdminEntity());
        return "login";
    }	
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clears the session
        return "redirect:/"; // Redirect to login page (or home page)
    }
	
}
