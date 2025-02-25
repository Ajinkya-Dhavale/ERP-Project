package com.erp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.admin.entity.AdminEntity;
import com.erp.admin.entity.Admission;
import com.erp.repo.AdminRepo;
import com.erp.service.AdmissionService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    private AdmissionService admissionService;
    
    @Autowired
    private AdminRepo adminRepo; 

    @GetMapping({"/", ""})  
    public String getIndex(HttpSession session) {
        return "Admin/index";
    }
    
    @PostMapping("/login")
    public String loginAdmin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) throws IOException {

//        System.out.println("Username: " + username);
//        System.out.println("Password: " + password);
//        System.out.println("Role: " + role);

        // Check if admin exists
        AdminEntity admin = adminRepo.findByUsernameAndPasswordAndRole(username, password, role);
//        System.out.println(admin);

        if (admin == null) {
        	 redirectAttributes.addFlashAttribute("error", "Invalid credentials.");
            return "redirect:/";  
        } else if(role.equals("account")) {
            return "redirect:/account";  
        }
        else if(role.equals("library"))
        {
        	return "redirect:/library";
        }
        else if(role.equals("scholarship"))
        {
        	return "redirect:/scholarship";
        }
        else if(role.equals("admin"))
        {
        	return "redirect:/admin";
        }
        return "redirect:/"; 
    }



    @GetMapping({"/add_student","/add_student/"})
    public String openAddStudent(Model model) {
        Admission admission = new Admission();
        model.addAttribute("admission", admission);
        return "Admin/add_student";
    }

    @GetMapping({"/view_student","/view_student/"})
    public String openViewStudent(Model model) {
    	
    	List<Admission> admissions_list=admissionService.getAllStudents();
    	model.addAttribute("admission_list",admissions_list);   	
    	
        return "Admin/view_student";
    }

    @PostMapping("/admission")
    public String takeAdmission(@ModelAttribute("admission") Admission admission, RedirectAttributes redirectAttributes) {
//        System.out.println("Received Admission: " + admission);

        // Check if Aadhar number already exists
        if (admissionService.checkAdmissionByAadhar(admission.getAadharNo())) {
            redirectAttributes.addFlashAttribute("error", "Aadhar already exist..!");
            return "redirect:/admin/add_student";
        }

        // Save the admission
        Admission savedAdmission = admissionService.saveAdmission(admission,redirectAttributes);

        // Success message
        redirectAttributes.addFlashAttribute("success", "Admission Done..!");

        return "redirect:/admin/add_student";
    }
    
}
