package com.erp.student.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.admin.entity.Admission;
import com.erp.student.entity.AcademicDetails;
import com.erp.student.entity.AttendanceEntity;
import com.erp.student.entity.BonafideEntity;
import com.erp.student.entity.PersonalDetails;
import com.erp.student.entity.StudentAddress;
import com.erp.student.entity.TCEntity;
import com.erp.student.repo.AcademicDetailsRepo;
import com.erp.student.repo.AddressRepo;
import com.erp.student.repo.AttendanceEntityRepo;
import com.erp.student.repo.BonafideRepository;
import com.erp.student.repo.PersonalDetailRepository;
import com.erp.student.repo.TCRepository;

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

	@Autowired
	private TCRepository tcRepository;
	
	@Autowired 
	private BonafideRepository bonafideRepository;
	
	@Autowired 
	private AttendanceEntityRepo attendanceEntityRepo;

	@GetMapping("/request_certificate")
	public String openCertificatePage(HttpSession session, Model model) {
		Admission student = (Admission) session.getAttribute("student");
		model.addAttribute("student", student);

		if (student == null) {
			return "redirect:/"; // Redirect if session expired or student not found
		}

		Optional<TCEntity> tcEntity = tcRepository.findByStudentIdAndTcTypeAndCertificateType(student.getAdmissionId(),
				"Original", "Transference Certificate");

		if (tcEntity.isPresent()) {
			model.addAttribute("tcPresent", true);
		}

		return "Student/request_certificate";
	}

	@PostMapping("/check_certificate_type")
	public String CheckCertificate(HttpServletRequest request, HttpSession httpSession, Model model,
			@RequestParam("certificate_type") String certficateType,
			@RequestParam("certificate_reason") String certificateReason,
			RedirectAttributes redirectAttributes
			) {

		Admission admission = (Admission) httpSession.getAttribute("student");

		if (admission == null) {
			return "redirect: /";
		}

		String studentId = admission.getAdmissionId();

		if (certficateType.equals("Transference Certificate")) {

			String tcType = request.getParameter("tc_type");

			// System.out.println(certficateType+tcType+certificateReason);

			TCEntity tcEntity = new TCEntity();

			// Fetch details from database
			Optional<PersonalDetails> personalDetail = personalDetailRepository.findByStudentId(studentId);
			Optional<AcademicDetails> academicDetails = academicDetailsRepo.findByStudentId(studentId);
			Optional<StudentAddress> studentAddress = addressRepo.findByStudentId(studentId);

			PersonalDetails personalDetails1 = null;
			StudentAddress studentAddress1 = null;

			if (personalDetail.isPresent() && academicDetails.isPresent() && studentAddress.isPresent()) {
				personalDetails1 = personalDetail.get();
				studentAddress1 = studentAddress.get();
				tcEntity.setAddress(studentAddress1.getPermanentAddress());
				tcEntity.setContactNo(personalDetails1.getMobile());

				tcEntity.setGender(personalDetails1.getGender());
				tcEntity.setCasteCategory(personalDetails1.getCaste());

			}
			else {
			    redirectAttributes.addFlashAttribute("error", "Please Fill Personal Details");
			    return "redirect:/student/request_certificate";
			}


			tcEntity.setStudentId(studentId);

			tcEntity.setCertificateType(certficateType);
			tcEntity.setTcType(tcType);
			tcEntity.setCertificateReason(certificateReason);
			tcEntity.setFirstName(admission.getFirstName());
			tcEntity.setMiddleName(admission.getMiddleName());
			tcEntity.setLastName(admission.getLastName());
			tcEntity.setEmailId(admission.getEmail());

			tcEntity.setApplicationFee(100.00);
			tcEntity.setProcessingFee(50.00);
			tcEntity.setTotalFee(150.00);

			model.addAttribute("tc", tcEntity);
			return "Student/tc";
		} else if (certficateType.equals("Migration Certificate")) {
			TCEntity tcEntity = new TCEntity();

			// Fetch details from database
			Optional<PersonalDetails> personalDetail = personalDetailRepository.findByStudentId(studentId);
			Optional<AcademicDetails> academicDetails = academicDetailsRepo.findByStudentId(studentId);
			Optional<StudentAddress> studentAddress = addressRepo.findByStudentId(studentId);

			PersonalDetails personalDetails1 = null;
			StudentAddress studentAddress1 = null;

			if (personalDetail.isPresent() && academicDetails.isPresent() && studentAddress.isPresent()) {
				personalDetails1 = personalDetail.get();
				studentAddress1 = studentAddress.get();

				tcEntity.setAddress(studentAddress1.getPermanentAddress());

				tcEntity.setContactNo(personalDetails1.getMobile());
				tcEntity.setGender(personalDetails1.getGender());
				tcEntity.setCasteCategory(personalDetails1.getCaste());

			}
			else {
			    redirectAttributes.addFlashAttribute("error", "Please Fill Personal Details");
			    return "redirect:/student/request_certificate";
			}


			tcEntity.setStudentId(studentId);

			tcEntity.setCertificateType(certficateType);
			tcEntity.setTcType("original");
			tcEntity.setCertificateReason(certificateReason);
			tcEntity.setFirstName(admission.getFirstName());
			tcEntity.setMiddleName(admission.getMiddleName());
			tcEntity.setLastName(admission.getLastName());
			tcEntity.setEmailId(admission.getEmail());

			tcEntity.setApplicationFee(200.00);
			tcEntity.setProcessingFee(50.00);
			tcEntity.setTotalFee(250.00);

			model.addAttribute("tc", tcEntity);
			return "Student/tc";
		} else if (certficateType.equals("Bonafide Certificate")) {
			
			Optional<PersonalDetails> personalDetail = personalDetailRepository.findByStudentId(studentId);
			Optional<AcademicDetails> academicDetails = academicDetailsRepo.findByStudentId(studentId);
			Optional<StudentAddress> studentAddress = addressRepo.findByStudentId(studentId);

			PersonalDetails personalDetails1 = null;
			StudentAddress studentAddress1 = null;
			AcademicDetails academicDetails1=null;
			
			BonafideEntity bonafide = new BonafideEntity();

			bonafide.setCertificateReason(certificateReason);
			bonafide.setCertificateType(certficateType);
			bonafide.setStudentId(studentId);
			bonafide.setFullName(admission.getLastName()+ " "+admission.getFirstName()+" "+admission.getMiddleName());
			bonafide.setTotalFees(50.00);
			
			
			if (personalDetail.isPresent() && academicDetails.isPresent() && studentAddress.isPresent()) {
				personalDetails1 = personalDetail.get();
				studentAddress1 = studentAddress.get();
				academicDetails1=academicDetails.get();
				
				bonafide.setDivision(academicDetails1.getSection());
				bonafide.setAdminApproval(0);
				bonafide.setApplicationDate(new Date());
				bonafide.setGender(personalDetails1.getGender());
				bonafide.setCourse(academicDetails1.getCourse());
				bonafide.setDepartment(academicDetails1.getDepartment());
				bonafide.setLocalAddress(studentAddress1.getTemporaryAddress());
				bonafide.setPermanentAddress(studentAddress1.getPermanentAddress());
			}
			
			else {
			    redirectAttributes.addFlashAttribute("error", "Please Fill Personal Details");
			    return "redirect:/student/request_certificate";
			}

			
			model.addAttribute("bonafide", bonafide);
			return "Student/bonafide";
		} else {
			
			AttendanceEntity attendanceEntity=new AttendanceEntity();
			
			Optional<PersonalDetails> personalDetail = personalDetailRepository.findByStudentId(studentId);
			Optional<AcademicDetails> academicDetails = academicDetailsRepo.findByStudentId(studentId);
			
			
			PersonalDetails personalDetails1 = null;
			AcademicDetails academicDetails1=null;
			
			attendanceEntity.setCertificateReason(certificateReason);
			attendanceEntity.setCertificateType(certficateType);
			attendanceEntity.setStudentId(studentId);
			attendanceEntity.setFullName(admission.getLastName()+ " "+admission.getFirstName()+" "+admission.getMiddleName());
			
			
			if(personalDetail.isPresent())
			{
				personalDetails1=personalDetail.get();
				academicDetails1=academicDetails.get();
				attendanceEntity.setDivision(academicDetails1.getSection());
				attendanceEntity.setAdminApproval(0);
				attendanceEntity.setApplicationDate(new Date());
				attendanceEntity.setGender(personalDetails1.getGender());
				attendanceEntity.setCourse(academicDetails1.getCourse());
				attendanceEntity.setDepartment(academicDetails1.getDepartment());
			}
			else {
			    redirectAttributes.addFlashAttribute("error", "Please Fill Personal Details");
			    return "redirect:/student/request_certificate";
			}

			
			model.addAttribute("attendance",attendanceEntity);
			
			return "Student/attendance";
		}

	}

	@GetMapping("/certificate_status")
	public String openCertificateStatus(Model model, HttpSession session) {
		Admission student = (Admission) session.getAttribute("student");
		if (student != null) {
			// Fetch certificates using studentId
			List<TCEntity> certificates = tcRepository.findByStudentId(student.getAdmissionId());
			List<BonafideEntity> bonafideEntities=bonafideRepository.findByStudentId(student.getAdmissionId());
			List<AttendanceEntity> attendanceEntities=attendanceEntityRepo.findByStudentId(student.getAdmissionId());
			
			// Add certificates to the model
			model.addAttribute("tcEntities", certificates);
			model.addAttribute("bonafides",bonafideEntities);
			model.addAttribute("attendances",attendanceEntities);
		} else {
			return "redirect:/";
		}
		return "Student/certificate_status";
	}

}
