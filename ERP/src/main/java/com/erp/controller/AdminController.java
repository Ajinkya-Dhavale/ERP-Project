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
import com.erp.repo.AdmissionRepo;
import com.erp.service.AdmissionService;
import com.erp.student.repo.AttendanceEntityRepo;
import com.erp.student.repo.BonafideRepository;
import com.erp.student.repo.TCRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    private AdmissionService admissionService;
    
    @Autowired
    private AdminRepo adminRepo; 
    
    @Autowired
    private AdmissionRepo admissionRepo;
    
    @Autowired
    private TCRepository tcRepository;
    
    @Autowired
    private BonafideRepository bonafideRepository;
    
    @Autowired
    private AttendanceEntityRepo attendanceEntityRepo;

    @GetMapping("/")  
    public String getIndex(HttpSession session,Model model) {
        // Check if "admin" attribute exists in session
        Object adminEmail = session.getAttribute("admin");

        if (adminEmail == null || !adminEmail.equals("admin@gmail.com")) {
            return "redirect:/";  // Redirect to login page if not logged in
        }
        
        int totalCount=admissionRepo.totalStudent();
        model.addAttribute("totalStudent",totalCount);
        
        
        int totaldublicate=tcRepository.countTCType("Duplicate","Transference Certificate");
        int totalOrginal=tcRepository.countTCType("Original","Transference Certificate");
        int migrationCertificate=tcRepository.countTCType("Original","Migration Certificate");
        model.addAttribute("totaldublicate",totaldublicate);
        model.addAttribute("totalOrginal",totalOrginal);
        model.addAttribute("migrationCertificate",migrationCertificate);
        
        int tcApproved=tcRepository.countTCApproval(1,"Transference Certificate");
        int tcPendding=tcRepository.countTCApproval(0,"Transference Certificate");
        int tcRejected=tcRepository.countTCApproval(2,"Transference Certificate");
        model.addAttribute("tcApproved",tcApproved);
        model.addAttribute("tcPendding",tcPendding);
        model.addAttribute("tcRejected",tcRejected);
        
        int mcApproved=tcRepository.countTCApproval(1,"Migration Certificate");
        int mcPendding=tcRepository.countTCApproval(0,"Migration Certificate");
        int mcRejected=tcRepository.countTCApproval(2,"Migration Certificate");
        model.addAttribute("mcApproved",mcApproved);
        model.addAttribute("mcPendding",mcPendding);
        model.addAttribute("mcRejected",mcRejected);
        
        long totalBonafide=bonafideRepository.count();
        long approvedBonafide=bonafideRepository.countByAdminApproval(1);
        long pendingBonafide=bonafideRepository.countByAdminApproval(0);
        long rejectedBonafide=bonafideRepository.countByAdminApproval(2);
        model.addAttribute("totalBonafide",totalBonafide);
        model.addAttribute("approvedBonafide",approvedBonafide);
        model.addAttribute("pendingBonafide",pendingBonafide);
        model.addAttribute("rejectedBonafide",rejectedBonafide);
 
        long totalAttendance=attendanceEntityRepo.count();
        long approvedAttendance=attendanceEntityRepo.countByAdminApproval(1);
        long pendingAttendance=attendanceEntityRepo.countByAdminApproval(0);
        long rejectedAttendance=attendanceEntityRepo.countByAdminApproval(2);
        model.addAttribute("totalAttendance",totalAttendance);
        model.addAttribute("approvedAttendance",approvedAttendance);
        model.addAttribute("pendingAttendance",pendingAttendance);
        model.addAttribute("rejectedAttendance",rejectedAttendance);
        
        return "Admin/index";  // Return admin dashboard
    }

    
    @PostMapping("/login")
    public String loginAdmin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            HttpSession session, RedirectAttributes redirectAttributes) {
    
        // Check if admin exists
        AdminEntity admin = adminRepo.findByUsernameAndPasswordAndRole(username, password, role);
    
        if (admin == null) {
            redirectAttributes.addFlashAttribute("error", "Invalid credentials.");
            return "redirect:/";  
        }
    
        // Set session attribute based on role
        session.setAttribute(role, admin.getUsername());
    
        // Redirect based on role
        switch (role) {
            case "admin":
                return "redirect:/admin/";
            case "account":
                return "redirect:/account/";
            case "library":
                return "redirect:/library/";
            case "scholarship":
                return "redirect:/scholarship/";
            default:
                redirectAttributes.addFlashAttribute("error", "Unauthorized role.");
                return "redirect:/";
        }
    }



    @GetMapping({"/add_student","/add_student/"})
    public String openAddStudent(Model model,HttpSession session) {
    	
    	 Object adminEmail = session.getAttribute("admin");

         if (adminEmail == null || !adminEmail.equals("admin@gmail.com")) {
             return "redirect:/";  // Redirect to login page if not logged in
         }
    	
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
    
    @GetMapping({"/open_bonafide/","/open_tc/","/open_attendance/"})
    public String openDashboard()
    {
    	return "redirect:/admin/";
    }
    
    
    
    
    
}
