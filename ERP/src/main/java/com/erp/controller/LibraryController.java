package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.student.entity.TCEntity;
import com.erp.student.repo.TCRepository;


@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	private TCRepository repository;
	
	@GetMapping({"","/"})
	public String openAccount() {
		return "Library/index";
	}
	
	
	@GetMapping("/new_request_certificate")
	public String openTCPage(Model model)
	{
		List<TCEntity> tcEntities = repository.findByLibraryApproval(0);
        model.addAttribute("tcEntities", tcEntities);

		return "Library/new_request_certificate";
	}
	
	@GetMapping("/approved_certificate")
	public String openTCPage1(Model model)
	{
		List<TCEntity> tcEntities = repository.findByLibraryApproval(1);
        model.addAttribute("tcEntities", tcEntities);

		return "Library/approved_certificate";
	}
	
	@GetMapping("/rejected_certificate")
	public String openTCPage2(Model model)
	{
		List<TCEntity> tcEntities = repository.findByLibraryApproval(2);
        model.addAttribute("tcEntities", tcEntities);

		return "Library/reject_certificate";
	}
	
	
//	main operation here
	
	@GetMapping("/approved_tc/{id}")
    public String approveTc(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.findById(id).ifPresent(tc -> {
            tc.setLibraryApproval(1); // Set approval to 1 (Approved)
            repository.save(tc); // Save changes
        });

        redirectAttributes.addFlashAttribute("message", "Transfer Certificate Approved Successfully!");
        return "redirect:/library/new_request_certificate";
    }

    @GetMapping("/reject_tc/{id}")
    public String rejectTc(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.findById(id).ifPresent(tc -> {
            tc.setLibraryApproval(2); // Set approval to 2 (Rejected)
            repository.save(tc); // Save changes
        });

        redirectAttributes.addFlashAttribute("message", "Transfer Certificate Rejected Successfully!");
        return "redirect:/library/new_request_certificate";
    }
	
}
