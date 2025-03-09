package com.erp.student.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.admin.entity.AdminEntity;
import com.erp.admin.entity.Admission;
import com.erp.student.entity.AcademicDetails;
import com.erp.student.entity.PersonalDetails;
import com.erp.student.entity.StudentAddress;
import com.erp.student.service.StudentService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping({ "/", "" })
	public String getStudentAdminPannel(HttpSession session,Model model) {
	
		if(session.getAttribute("student")==null)
		{
			return "redirect:/";
		}
		 
		return "Student/index.html";
	}

	@PostMapping("/login")
	public String loginAdmin(
	        @RequestParam("username") String username,
	        @RequestParam("password") String password,
	        Model model, RedirectAttributes redirectAttributes,HttpSession session) {
		//System.out.println("ajinkya");
//		return "Student/index";

	    Admission student = studentService.findByUsernameAndPassword(username, password);

//	    System.out.println(student);
	    
	    if (student == null) {
	        redirectAttributes.addFlashAttribute("error", "Invalid credentials.");
	        return "redirect:/"; 
	    }

	    
	    session.setAttribute("student", student);
	    model.addAttribute("student", student); 
	    return "Student/index"; 
	}

	
	@GetMapping({ "/personal_details", "/personal_details/" })
	public String getPersonal_details(Model model, HttpSession session) {

		Admission student = (Admission) session.getAttribute("student");
		
		PersonalDetails personalDetails1=studentService.getPersonalDetailByStudentId(student.getAdmissionId());
		personalDetails1.setStudentId(student.getAdmissionId());
		model.addAttribute("personal_details",personalDetails1);
		return "Student/personal_details";
	}
	
	@PostMapping("/save_personal_details")
    public String savePersonalDetail(@ModelAttribute PersonalDetails personalDetail) {
        studentService.savePersonalDetail(personalDetail);
        return "redirect:/student/personal_details";  // Redirect after saving
    }
	
	@GetMapping({ "/academic_details", "/academic_details/" })
	public String getAcademicDetails(HttpSession session,Model model) {
		Admission student=(Admission)session.getAttribute("student");
		
		AcademicDetails academicDetails=studentService.getAcademicDetailByStudentId(student.getAdmissionId());
		academicDetails.setStudentId(student.getAdmissionId());
		String year= student.getStartDate();
		year = year.split("-")[2];
		academicDetails.setAdmissionYear(year);
		
		model.addAttribute("academic_details",academicDetails);
		return "Student/academic_details";
	}
	
	@PostMapping("/save_academic_details")
    public String saveAcademicDetails(@ModelAttribute AcademicDetails academicDetails) {
        studentService.saveOrUpdateAcademicDetails(academicDetails);
        return "redirect:/student/academic_details";  // Redirect after saving
    }
	
	
	@GetMapping({ "/address", "/address/" })
	public String getAddress(HttpSession session,Model model) {
		Admission student=(Admission)session.getAttribute("student");
		
		StudentAddress studentAddress=studentService.getAddressByStudentId(student.getAdmissionId());
		studentAddress.setStudentId(student.getAdmissionId());
		model.addAttribute("address",studentAddress);
		return "Student/address";
	}
	
	@PostMapping("/save_address")
    public String saveAddress(@ModelAttribute StudentAddress studentAddress) {
        studentService.saveOrUpdateStudentAddress(studentAddress);
        return "redirect:/student/address";  // Redirect after saving
    }
	
	@GetMapping({ "/photo_sign", "/photo_sign/" })
	public String getPhotoAnsSign(Model model) {
		model.addAttribute("fileTypes", "image/png, image/gif, image/jpeg");
		return "Student/photo_sign";
	}
	
	
	
}

