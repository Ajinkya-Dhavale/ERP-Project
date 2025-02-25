package com.erp.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/student")
public class CertificateController {
	@GetMapping("/request_certificate")
	public String openCertificatePage() {
		return "Student/request_certificate";
	}
	
	@GetMapping("/tc")
	public String openTcCertificate()
	{
		return "Student/tc";
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
