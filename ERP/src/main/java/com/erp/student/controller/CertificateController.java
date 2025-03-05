package com.erp.student.controller;


import java.util.Date;
import java.util.Optional;

import com.erp.student.entity.TCEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erp.admin.entity.Admission;
import com.erp.student.entity.AcademicDetails;
import com.erp.student.entity.PersonalDetails;
import com.erp.student.entity.StudentAddress;
import com.erp.student.repo.AcademicDetailsRepo;
import com.erp.student.repo.AddressRepo;
import com.erp.student.repo.PersonalDetailRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class CertificateController {

	@Autowired
	private PersonalDetailRepository personalDetailRepository;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private AcademicDetailsRepo academicDetailsRepo;
	
	@GetMapping("/request_certificate")
	public String openCertificatePage(HttpSession session,Model model) {
		Admission student=(Admission)session.getAttribute("student");
		model.addAttribute("student",student);
		
		 if (student == null) {
		        return "redirect:/"; // Redirect if session expired or student not found
		    }
		 
		return "Student/request_certificate";
	}
	
	@PostMapping("/check_certificate_type")
	public String CheckCertificate(HttpServletRequest request,HttpSession httpSession,Model model,@RequestParam("certificate_type") String certficateType, @RequestParam("certificate_reason") String certificateReason)
	{

		Admission admission= (Admission) httpSession.getAttribute("student");
		
		String studentId=admission.getAdmissionId();
		
		
		if(certficateType.equals("Transference Certificate"))
		{  
			String tcType=request.getParameter("tc_type");
		    
			TCEntity tcEntity=new TCEntity();
			
		    // Fetch details from database
		    Optional<PersonalDetails> personalDetail = personalDetailRepository.findByStudentId(studentId);
		    Optional<AcademicDetails> academicDetails = academicDetailsRepo.findByStudentId(studentId);
		    Optional<StudentAddress> studentAddress = addressRepo.findByStudentId(studentId);

		    PersonalDetails personalDetails1=null;
		    StudentAddress studentAddress1 = null;
		    
		    if(personalDetail.isPresent() && academicDetails.isPresent() && studentAddress.isPresent())
		    {
		    	personalDetails1=personalDetail.get();
		    	studentAddress1=studentAddress.get();		    	
		    }
		    
		    tcEntity.setStudentId(studentId);
		    
		    tcEntity.setCertificateType(certficateType);
		    tcEntity.setTcType(tcType);
		    tcEntity.setCertificateReason(certificateReason);
		    tcEntity.setFirstName(admission.getFirstName());
		    tcEntity.setMiddleName(admission.getMiddleName());
		    tcEntity.setLastName(admission.getLastName());
		    tcEntity.setAddress(studentAddress1.getPermanentAddress());
		    
		    tcEntity.setContactNo(personalDetails1.getMobile());
		    tcEntity.setEmailId(admission.getEmail());
		    tcEntity.setGender(personalDetails1.getGender());
		    tcEntity.setCasteCategory(personalDetails1.getCaste());
		    
		    tcEntity.setApplicationFee(100.00);
		    tcEntity.setProcessingFee(50.00);
		    tcEntity.setTotalFee(150.00);

		    
			
			model.addAttribute("tc",tcEntity);
			return "Student/tc";
		}
		else if(certficateType.equals("Migration Certificate"))
		{
			return "Student/tc";
		}
		else if(certficateType.equals("Bonafide Certificate"))
		{
			return "Student/bonafide";
		}
		else
		{
			return "Student/attendance";
		}
		
//		return "redirect:/student";
	}

	
	
	


	@GetMapping("/bonafide")
	public String openBonafideCertificate()
	{
		return "Student/bonafide";
	}
	
	@GetMapping("/attendance")
	public String openAttendenceCertificate()
	{
		return "Student/attendance";
	}
	
}
