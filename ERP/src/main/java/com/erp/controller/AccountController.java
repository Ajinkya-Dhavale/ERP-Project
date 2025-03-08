package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.student.entity.TCEntity;
import com.erp.student.repo.TCRepository;


@Controller
@RequestMapping("/account")

public class AccountController {

	@Autowired
	private TCRepository repository;
	
	@GetMapping({"","/"})
	public String openAccount() {
		return "Account/index";
	}
	
	
	@GetMapping("/new_request_certificate")
	public String openTCPage(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAccountApproval(0);
        model.addAttribute("tcEntities", tcEntities);

		return "Account/new_request_certificate";
	}
	
	@GetMapping("/approved_certificate")
	public String openTCPage1(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAccountApproval(1);
        model.addAttribute("tcEntities", tcEntities);

		return "Account/approved_certificate";
	}
	
	@GetMapping("/rejected_certificate")
	public String openTCPage2(Model model)
	{
		List<TCEntity> tcEntities = repository.findByAccountApproval(2);
        model.addAttribute("tcEntities", tcEntities);

		return "Account/reject_certificate";
	}
	
	
//	main operation here
	
	@GetMapping("/approved_tc/{id}")
    public String approveTc(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.findById(id).ifPresent(tc -> {
            tc.setAccountApproval(1); // Set approval to 1 (Approved)
            repository.save(tc); // Save changes
        });

        redirectAttributes.addFlashAttribute("message", "Transfer Certificate Approved Successfully!");
        return "redirect:/account/new_request_certificate";
    }

    @GetMapping("/reject_tc/{id}")
    public String rejectTc(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.findById(id).ifPresent(tc -> {
            tc.setAccountApproval(2); // Set approval to 2 (Rejected)
            repository.save(tc); // Save changes
        });

        redirectAttributes.addFlashAttribute("message", "Transfer Certificate Rejected Successfully!");
        return "redirect:/account/new_request_certificate";
    }

}
