package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.erp.entity.AdminEntity;
import com.erp.entity.DeptEntity;
import com.erp.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	
	
	@GetMapping("/")
    public String getLogin(Model model) {
        model.addAttribute("admin", new AdminEntity());
//        model.addAttribute("dept",new DeptEntity());        
        return "login";
    }
	
	@GetMapping("/admin")
	public String getIndex(HttpSession session){
		 if (session.getAttribute("admin") == null) {
	            return "redirect:/"; 
	        }
	        return "index";
	}
	
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/"; 
    }
	
	@PostMapping("/check_admin")
    public String checkAdmin(@ModelAttribute("admin") AdminEntity admin, Model model,  HttpSession session) {
		AdminEntity validAdmin = adminService.validateAdmin(admin.getUsername(), admin.getPassword());

        if (validAdmin != null) {
            session.setAttribute("admin", validAdmin);
            return "redirect:/admin"; 
        } else {
            return "redirect:/"; 
        }    }
	
	@GetMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";  
    }
}
