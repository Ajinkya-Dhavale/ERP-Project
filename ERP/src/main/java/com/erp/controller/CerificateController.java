package com.erp.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.student.entity.TCEntity;
import com.erp.student.repo.TCRepository;

@Controller
@RequestMapping("/admin")
public class CerificateController {
	
	@Autowired
	public TCRepository repository;
	
	@GetMapping("/view_pending_tc")
	public String openTCPage(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAdminApproval(0);
        model.addAttribute("tcEntities", tcEntities);

		return "Admin/view_tc_certificate";
	}
	
	@GetMapping("/view_approved_tc")
	public String openTCPage1(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAdminApproval(1);
        model.addAttribute("tcEntities", tcEntities);

		return "Admin/view_approved_tc";
	}
	
	@GetMapping("/view_rejected_tc")
	public String openTCPage2(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAdminApproval(2);
        model.addAttribute("tcEntities", tcEntities);

		return "Admin/view_rejected_tc";
	}
	
	@GetMapping("/view_tc_application/{id}")
	public String viewApplication(@PathVariable Long id, Model model) {
	    Optional<TCEntity> application = repository.findById(id);
	    
	    if (application.isPresent()) {
	        model.addAttribute("tc", application.get()); 
	        // Add entity to model
	        System.out.println(application.get());
	        return "admin/view_tc_application";
	    } else {
	        return "redirect:/admin/view_tc_certificate";
	    }
	}
	
	
	@GetMapping("/verify_tc_certificate/{id}")
	public String approveCertificate(@PathVariable Long id) {
	   
		repository.findById(id).ifPresent(tc -> {
            tc.setAdminApproval(1); // Set approval to 1 (Approved)
            tc.setIssueDate(new Date());
            repository.save(tc); // Save changes
        });

	     return "redirect:/admin/view_pending_tc"; // ✅ Redirect to view page
	    
	}
	
	@GetMapping("/reject_tc_certificate/{id}")
	public String rejectCertificate(@PathVariable Long id) {
	   
		repository.findById(id).ifPresent(tc -> {
            tc.setAdminApproval(2); // Set approval to 1 (Approved)
            repository.save(tc); // Save changes
        });

	     return "redirect:/admin/view_pending_tc"; // ✅ Redirect to view page
	    
	}
	
	
	@GetMapping("/open_tc")
	public String openTC(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAdminApproval(0);
        model.addAttribute("tcEntities", tcEntities);

		return "Admin/view_tc_certificate";
	}



}
