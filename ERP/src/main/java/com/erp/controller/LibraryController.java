package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.student.entity.TCEntity;
import com.erp.student.repo.TCRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	private TCRepository repository;
	
	@Autowired
	private JavaMailSender mailSender;
	
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
	        
	        // Send rejection email notification
	        try {
	        	sendLibraryDuesEmail(tc.getEmailId(), tc.getFirstName(), tc.getLastName());
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            redirectAttributes.addFlashAttribute("errorMessage", "TC rejected but failed to send email notification.");
	        }
	    });

	    redirectAttributes.addFlashAttribute("message", "Transfer Certificate Rejected Successfully!");
	    return "redirect:/library/new_request_certificate";
	}

    
    private void sendLibraryDuesEmail(String to, String firstName, String lastName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String subject = "Important Notice Regarding Library Dues";
        String body = "<html><body>"
                + "<h3>Dear " + firstName + " " + lastName + ",</h3>"
                + "<p>Our records indicate that there are pending library dues associated with your account.</p>"
                + "<p>Please note that clearing these dues is essential for any future processing of your <b>Transfer Certificate (TC)</b>.</p>"
                + "<p>If you have already settled your dues, kindly provide the payment receipt to our office for verification.</p>"
                + "<p>Otherwise, we request you to visit the <b>library office</b> at your earliest convenience to resolve the matter.</p>"
                + "<p>Thank you for your prompt attention to this issue.</p>"
                + "<br>"
                + "<p><b>Best regards,</b><br>"
                + "Fergusson College (Autonomous), Pune<br>"
                + "<i>library.fc@gmail.com</i></p>"
                + "</body></html>";

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true); // ✅ Enable HTML format

        mailSender.send(message); // ✅ Send email
    }

	
}
