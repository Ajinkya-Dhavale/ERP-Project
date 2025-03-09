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
@RequestMapping("/account")

public class AccountController {

	@Autowired
	private TCRepository repository;
	
	@Autowired
	private JavaMailSender mailSender;
	
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

	        // Send email notification about rejection due to account dues
	        try {
	        	sendAccountDuesEmail(tc.getEmailId(), tc.getFirstName(), tc.getLastName());
	        } catch (MessagingException e) {
	            e.printStackTrace(); // Log the error for debugging
	        }
	    });

	    redirectAttributes.addFlashAttribute("message", "Transfer Certificate Rejected Successfully!");
	    return "redirect:/account/new_request_certificate";
	}

    
    private void sendAccountDuesEmail(String to, String firstName, String lastName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String subject = "You Have Outstanding Account Dues";
        String body = "<html><body>"
                + "<h3>Dear " + firstName + " " + lastName + ",</h3>"
                + "<p>We hope you are doing well.</p>"
                + "<p>Our records indicate that you have <b>outstanding account dues</b> that need to be cleared.</p>"
                + "<p>Please note that these dues must be settled before we can proceed with any further processing, including your <b>Transfer Certificate (TC)</b>.</p>"
                + "<p>If you have already made the payment, kindly forward your payment confirmation to the <b>Accounts Office</b> for verification.</p>"
                + "<p>For any questions or further assistance, please contact our <b>accounts department</b>.</p>"
                + "<p>Thank you for your prompt attention to this matter.</p>"
                + "<br>"
                + "<p><b>Best regards,</b><br>"
                + "Fergusson College (Autonomous), Pune<br>"
                + "<i>account.fc@gmail.com</i></p>"
                + "</body></html>";

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true); // ✅ Enable HTML format

        mailSender.send(message); // ✅ Send email
    }


}
