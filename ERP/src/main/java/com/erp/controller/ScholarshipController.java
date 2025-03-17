package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.repo.AdmissionRepo;
import com.erp.student.entity.TCEntity;
import com.erp.student.repo.TCRepository;

@Controller
@RequestMapping("/scholarship")
public class ScholarshipController {
	
	@Autowired
	private TCRepository repository;
	
	@Autowired
	private AdmissionRepo admissionRepo;
	
	@GetMapping({"","/"})
	public String openAccount(Model model) {
long totalStudent=admissionRepo.count();
		
		long totalTC=repository.count();
		long totalA=repository.countByScholarshipApproval(1);
		long totalP=repository.countByScholarshipApproval(0);
		long totalR=repository.countByScholarshipApproval(2);
		
		model.addAttribute("totalStudent",totalStudent);
		model.addAttribute("totalA",totalA);
		model.addAttribute("totalP",totalP);
		model.addAttribute("totalR",totalR);	
		model.addAttribute("totalTC",totalTC);
		return "Scholarship/index";
	}
	
	
	@GetMapping("/new_request_certificate")
	public String openTCPage(Model model)
	{
		List<TCEntity> tcEntities = repository.findByScholarshipApproval(0);
        model.addAttribute("tcEntities", tcEntities);

		return "Scholarship/new_request_certificate";
	}
	
	@GetMapping("/approved_certificate")
	public String openTCPage1(Model model)
	{
		List<TCEntity> tcEntities = repository.findByScholarshipApproval(1);
        model.addAttribute("tcEntities", tcEntities);

		return "Scholarship/approved_certificate";
	}
	
	@GetMapping("/rejected_certificate")
	public String openTCPage2(Model model)
	{
		List<TCEntity> tcEntities = repository.findByScholarshipApproval(2);
        model.addAttribute("tcEntities", tcEntities);

		return "Scholarship/reject_certificate";
	}
	
	
//	main operation here
	
	@GetMapping("/approved_tc/{id}")
    public String approveTc(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.findById(id).ifPresent(tc -> {
            tc.setScholarshipApproval(1); // Set approval to 1 (Approved)
            repository.save(tc); // Save changes
        });

        redirectAttributes.addFlashAttribute("message", "Transfer Certificate Approved Successfully!");
        return "redirect:/scholarship/new_request_certificate";
    }

    @GetMapping("/reject_tc/{id}")
    public String rejectTc(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.findById(id).ifPresent(tc -> {
            tc.setScholarshipApproval(2); // Set approval to 2 (Rejected)
            repository.save(tc); // Save changes
        });

        redirectAttributes.addFlashAttribute("message", "Transfer Certificate Rejected Successfully!");
        return "redirect:/scholarship/new_request_certificate";
    }
}
